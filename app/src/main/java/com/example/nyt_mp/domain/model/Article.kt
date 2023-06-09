package com.example.nyt_mp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val abstract: String,
    val byLine: String,
    val desFacet: List<String>,
    val geoFacet: List<String>,
    val id: Long,
    val media: Media,
    val publishedDate: String,
    val section: String,
    val subSection: String,
    val title: String,
    val updated: String,
    val url: String
): Parcelable
