package com.example.nyt_mp.presentation.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nyt_mp.presentation.common.AppTopAppBar
import com.example.nyt_mp.presentation.home.components.ArticleItem
import com.example.nyt_mp.presentation.home.components.ErrorScreen
import com.example.nyt_mp.presentation.common.NoInternetConnection
import com.example.nyt_mp.presentation.destinations.ArticleDetailsScreenDestination
import com.example.nyt_mp.presentation.home.components.SectionsList
import com.example.nyt_mp.presentation.home.components.Title
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val articlesState by remember(viewModel.articleState) { viewModel.articleState }
    val sectionsState by remember { viewModel.sectionsState }
    val isOnline by remember { viewModel.isOnline }

    LaunchedEffect(key1 = true) {
        viewModel.observeNetworkState()
    }

    LaunchedEffect(key1 = isOnline) {
        if (isOnline && articlesState.articles.isEmpty()) viewModel.getMostPopularArticles()
    }

    when {
        !isOnline -> {
            NoInternetConnection()
        }

        articlesState.isLoading -> {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color(0xFF, 0xFE, 0xFE, 0x8C))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = {}
                    )
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(15.dp)
                        .size(30.dp),
                    color = Black
                )
            }
        }

        articlesState.filteredArticles.isNotEmpty() -> {
            Column(modifier = Modifier.fillMaxSize()) {
                AppTopAppBar()

                Title(text = "Most Popular Articles")

                SectionsList(
                    sectionsState.sections
                ) { selectedSection ->
                    viewModel.filterArticles(selectedSection)
                }
                AnimatedContent(targetState = articlesState.filteredArticles) { state ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.Top),
                        contentPadding = PaddingValues(bottom = 20.dp)
                    ) {

                        items(state) { article ->
                            ArticleItem(article = article) {
                                navigator.navigate(ArticleDetailsScreenDestination(article))
                            }
                        }
                    }
                }
            }
        }

        !articlesState.error.isNullOrEmpty() -> {
            ErrorScreen(articlesState.error!!)
        }
        else -> {
        }
    }
}