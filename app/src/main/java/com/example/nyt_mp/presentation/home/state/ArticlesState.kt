package com.example.nyt_mp.presentation.home.state

import com.example.nyt_mp.domain.model.Article

data class ArticlesState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    var filteredArticles: List<Article> = emptyList(),
    val error: String? = null
)
