package com.example.nyt_mp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Media(
    val caption: String,
    val thumbnailUrl: String,
    val mediumImgUrl: String,
    val largeImgUrl: String,
    val type: String //image
): Parcelable
