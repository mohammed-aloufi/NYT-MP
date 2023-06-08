package com.example.nyt_mp.domain.model

data class Article(
    val abstract: String,
    val byLine: String,
    val desFacet: List<String>,
    val geoFacet: List<String>,
    val id: Long,
    val media: List<Media>,
    val publishedDate: String,
    val section: String,
    val subSection: String,
    val title: String,
    val updated: String,
    val url: String
)
