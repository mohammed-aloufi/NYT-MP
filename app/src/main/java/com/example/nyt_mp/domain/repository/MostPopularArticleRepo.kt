package com.example.nyt_mp.domain.repository

import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.domain.model.NetworkResult
import kotlinx.coroutines.flow.Flow

interface MostPopularArticleRepo {

    suspend fun getMostPopularArticles(): Flow<NetworkResult<List<Article>>>
}