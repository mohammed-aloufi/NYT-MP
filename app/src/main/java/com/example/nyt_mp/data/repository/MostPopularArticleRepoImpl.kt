package com.example.nyt_mp.data.repository

import android.util.Log
import com.example.nyt_mp.data.remote.MostPopularApiService
import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.domain.model.NetworkResult
import com.example.nyt_mp.domain.repository.MostPopularArticleRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "MostPopularArticleRepoI"
class MostPopularArticleRepoImpl @Inject constructor(
    private val apiService: MostPopularApiService
): MostPopularArticleRepo {

    override suspend fun getMostPopularArticles(): Flow<NetworkResult<List<Article>>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response = apiService.getMostPopularArticles()
            if (response.isSuccessful) {
                val body = response.body()?.articles?.mapNotNull {
                    it.toArticle()
                } ?: emptyList()
                emit(NetworkResult.Success(body))
            } else {
                emit(NetworkResult.Failure(response.message()))
            }
        } catch (e: Exception) {
            Log.e(TAG, "getMostPopularArticles: ", e)
        }
    }

}