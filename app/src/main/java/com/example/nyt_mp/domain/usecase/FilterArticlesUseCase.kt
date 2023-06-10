package com.example.nyt_mp.domain.usecase

import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.domain.model.NetworkResult
import com.example.nyt_mp.utils.Constants.ALL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FilterArticlesUseCase {
    operator fun invoke(articles: List<Article>, selectedSection: String): Flow<NetworkResult<List<Article>>> = flow {
        emit(NetworkResult.Loading)
        if (selectedSection == ALL) {
            emit(NetworkResult.Success(articles))
        } else {
            val filteredArticles = articles.filter {
                it.section == selectedSection
            }
            if (filteredArticles.isNotEmpty()) emit(NetworkResult.Success(filteredArticles))
            else emit(NetworkResult.Failure("No articles found"))
        }
    }
}