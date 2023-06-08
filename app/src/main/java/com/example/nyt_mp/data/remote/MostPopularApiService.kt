package com.example.nyt_mp.data.remote

import com.example.nyt_mp.BuildConfig
import com.example.nyt_mp.data.remote.dto.MostPopularArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MostPopularApiService {

    @GET("mostpopular/v2/viewed/1.json")
    suspend fun getMostPopularArticles(
        @Query("api-key") apiKey: String = BuildConfig.NY_TIMES_MP_API_KEY,
    ): Response<MostPopularArticlesResponse>
}