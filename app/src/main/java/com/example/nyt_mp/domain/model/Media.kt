package com.example.nyt_mp.domain.model

data class Media(
    val caption: String,
    val mediaMetadata: List<MediaMetadata>,
    val type: String //image
)
