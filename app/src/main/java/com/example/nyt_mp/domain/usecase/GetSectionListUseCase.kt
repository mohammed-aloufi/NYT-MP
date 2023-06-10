package com.example.nyt_mp.domain.usecase

import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.domain.model.NetworkResult
import com.example.nyt_mp.utils.Constants.ALL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSectionListUseCase {
    operator fun invoke(articles: List<Article>): Flow<NetworkResult<List<String>>> = flow {
        emit(NetworkResult.Loading)
        val sections = listOf(ALL) + articles.filter { it.section.isNotEmpty() }.map { it.section }.distinct()
        emit(NetworkResult.Success(sections))
    }
}