package com.example.nyt_mp.data.remote

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.nyt_mp.domain.model.Article
import javax.inject.Inject

class PagingSource @Inject constructor(
    private val apiService: MostPopularApiService
): PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val currKey = params.key ?: 1

            val response = apiService.getMostPopularArticles(page = currKey)

            if (response.isSuccessful) {
                val prevKey = if (currKey > 0) currKey - 1 else null
                val nextKey = if (!response.body()?.articles.isNullOrEmpty()) currKey + 1 else null

                val body = response.body()?.articles?.mapNotNull {
                    it.toArticle()
                } ?: emptyList()

                LoadResult.Page(
                    data = body,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Error(Exception())
            }
        } catch (e: Exception) {
            Log.d("TAG", "load: ${e.printStackTrace()}")
            LoadResult.Error(e)
        }
    }
}