@file:OptIn(ExperimentalCoroutinesApi::class)

package com.example.nyt_mp.presentation.home

import com.example.nyt_mp.data.HomeViewModelTestData.get3Articles
import com.example.nyt_mp.data.HomeViewModelTestData.getArticlesWithoutSections
import com.example.nyt_mp.data.HomeViewModelTestData.getMostPopularArticlesResponse
import com.example.nyt_mp.data.HomeViewModelTestData.getMostPopularArticlesResponseWithOneArticleMissingATitle
import com.example.nyt_mp.data.remote.MostPopularApiService
import com.example.nyt_mp.data.repository.MostPopularArticleRepoImpl
import com.example.nyt_mp.domain.repository.MostPopularArticleRepo
import com.example.nyt_mp.domain.usecase.FilterArticlesUseCase
import com.example.nyt_mp.domain.usecase.GetMostPopularArticlesUseCase
import com.example.nyt_mp.domain.usecase.GetSectionListUseCase
import com.example.nyt_mp.utils.ConnectivityObserver
import com.example.nyt_mp.utils.CoroutinesTestRule
import com.example.nyt_mp.utils.TestDispatchers
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class HomeViewModelTest {

    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

    @Mock
    private lateinit var apiService: MostPopularApiService
    @Mock
    private lateinit var connectivityObserver: ConnectivityObserver
    private lateinit var repository: MostPopularArticleRepo
    private lateinit var getMostPopularArticlesUseCase: GetMostPopularArticlesUseCase
    private lateinit var getSectionListUseCase: GetSectionListUseCase
    private lateinit var filterArticlesUseCase: FilterArticlesUseCase
    private lateinit var testDispatchers: TestDispatchers

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        repository = MostPopularArticleRepoImpl(apiService)
        getMostPopularArticlesUseCase = GetMostPopularArticlesUseCase(repository)
        getSectionListUseCase = GetSectionListUseCase()
        filterArticlesUseCase = FilterArticlesUseCase()
        testDispatchers = TestDispatchers()

        viewModel = HomeViewModel(
            getMostPopularArticlesUseCase = getMostPopularArticlesUseCase,
            connectivityObserver = connectivityObserver,
            getSectionListUseCase = getSectionListUseCase,
            filterArticlesUseCase = filterArticlesUseCase,
            defaultDispatchers = testDispatchers
        )
    }

    /**
     * getMostPopularArticles()
     * */

    @Test
    fun `getMostPopularArticles(), SUCCESS api returns 3 valid dtos, then returns 3 mapped Articles`() = runTest {
        Mockito.`when`(apiService.getMostPopularArticles()).thenReturn(Response.success(getMostPopularArticlesResponse()))
        viewModel.getMostPopularArticles()
        assertThat(viewModel.articleState.value.articles).isEqualTo(get3Articles())
    }

    @Test
    fun `getMostPopularArticles(), SUCCESS api returns 3 Articles dtos and one of them is missing a required value, then returns 2 mapped Articles`() = runTest {
        Mockito.`when`(apiService.getMostPopularArticles()).thenReturn(Response.success(getMostPopularArticlesResponseWithOneArticleMissingATitle()))
        viewModel.getMostPopularArticles()
        assertThat(viewModel.articleState.value.articles.size).isEqualTo(2)
    }

    @Test
    fun `getMostPopularArticles(), FAILURE api returns error, articleState error must not be null`() = runTest {
        Mockito.`when`(apiService.getMostPopularArticles()).thenReturn(Response.error(500, "Error".toResponseBody()))
        viewModel.getMostPopularArticles()
        assertThat(viewModel.articleState.value.error).isEqualTo("Error")
    }

    /**
     * getSectionList()
     * */

    @Test
    fun `getSectionList(), success returns suction extracted from articles, plus generic section All`() = runTest {
        viewModel.getSectionList(get3Articles())
        assertThat(viewModel.sectionsState.value.sections.count()).isEqualTo(4)
    }

    @Test
    fun `getSectionList(), returns generic section All only since articles section are empty`() = runTest {
        viewModel.getSectionList(getArticlesWithoutSections())
        assertThat(viewModel.sectionsState.value.sections.count()).isEqualTo(1)
    }

    /**
     * filterArticles(), TODO: finish unit test for filterArticles feature
     * */
}