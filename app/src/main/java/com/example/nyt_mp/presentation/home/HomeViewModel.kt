package com.example.nyt_mp.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.domain.model.NetworkResult
import com.example.nyt_mp.domain.usecase.FilterArticlesUseCase
import com.example.nyt_mp.domain.usecase.GetMostPopularArticlesUseCase
import com.example.nyt_mp.domain.usecase.GetSectionListUseCase
import com.example.nyt_mp.presentation.home.state.ArticlesState
import com.example.nyt_mp.presentation.home.state.SectionsState
import com.example.nyt_mp.utils.ConnectivityObserver
import com.example.nyt_mp.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "HomeViewModel"
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMostPopularArticlesUseCase: GetMostPopularArticlesUseCase,
    private val connectivityObserver: ConnectivityObserver,
    private val getSectionListUseCase: GetSectionListUseCase,
    private val filterArticlesUseCase: FilterArticlesUseCase,
    private val defaultDispatchers: DispatcherProvider,
): ViewModel() {

    private val _articleState = mutableStateOf(ArticlesState())
    val articleState: State<ArticlesState> = _articleState

    private val _isOnline = mutableStateOf(true)
    val isOnline: State<Boolean> = _isOnline

    private val _sectionsState = mutableStateOf(SectionsState())
    val sectionsState: State<SectionsState> = _sectionsState


     fun observeNetworkState() = viewModelScope.launch(defaultDispatchers.main) {
        connectivityObserver.observeNetworkState().collectLatest { isOnline ->
            _isOnline.value = isOnline && sectionsState.value.sections.isNotEmpty()
        }
    }

    fun getMostPopularArticles() = viewModelScope.launch(defaultDispatchers.main) {
        getMostPopularArticlesUseCase().collectLatest { result ->
            when(result) {
                is NetworkResult.Loading -> _articleState.value = ArticlesState(isLoading = true)
                is NetworkResult.Success -> {
                    getSectionList(result.data)
                    _articleState.value = ArticlesState(articles = result.data, filteredArticles = result.data)
                }
                is NetworkResult.Failure -> _articleState.value = ArticlesState(error = result.error)
            }
        }
    }

    fun getSectionList(articles: List<Article>) = viewModelScope.launch(defaultDispatchers.main) {
        getSectionListUseCase(articles).collectLatest {
                result ->
            when(result) {
                is NetworkResult.Loading -> _sectionsState.value = SectionsState(isLoading = true)
                is NetworkResult.Success -> _sectionsState.value = SectionsState(sections = result.data)
                is NetworkResult.Failure -> _sectionsState.value = SectionsState(error = result.error)
            }
        }
    }

    fun filterArticles(selectedSection: String) = viewModelScope.launch(defaultDispatchers.main) {
        filterArticlesUseCase(_articleState.value.articles, selectedSection).collectLatest { result ->
            when(result) {
                is NetworkResult.Loading -> _articleState.value = articleState.value.copy(isLoading = true)
                is NetworkResult.Success -> _articleState.value = _articleState.value.copy(filteredArticles = result.data, isLoading = false)
                is NetworkResult.Failure -> _articleState.value = articleState.value.copy(error = result.error, isLoading = false)
            }
        }
    }
}