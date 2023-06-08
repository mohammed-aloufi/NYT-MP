package com.example.nyt_mp.data.remote.dto

import com.example.nyt_mp.domain.model.MediaMetadata
import com.google.gson.annotations.SerializedName

data class MediaMetadataDto(
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("url")
    val url: String? = null
) {
    fun toMediaMetadata(): MediaMetadata? {
        // TODO: exclude on format
        return if (format == null || height == null || width == null || url == null) null
        else MediaMetadata(
            format = format,
            height = height,
            width =  width,
            url = url
        )
    }
}