package com.example.nyt_mp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class MostPopularArticlesResponse(
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("num_results")
    val numOfResults: Int? = null,
    @SerializedName("results")
    val articles: List<ArticleDto>? = null,
    @SerializedName("status")
    val status: String? = null
)