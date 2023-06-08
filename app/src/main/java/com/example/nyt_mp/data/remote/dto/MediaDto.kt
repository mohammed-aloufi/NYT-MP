package com.example.nyt_mp.data.remote.dto

import com.example.nyt_mp.domain.model.Media
import com.google.gson.annotations.SerializedName

data class MediaDto(
    @SerializedName("approved_for_syndication")
    val approvedForSyndication: Int? = null,
    @SerializedName("caption")
    val caption: String? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("media-metadata")
    val mediaMetadata: List<MediaMetadataDto>? = null,
    @SerializedName("subtype")
    val subtype: String? = null,
    @SerializedName("type")
    val type: String? = null,
) {
    fun toMedia(): Media? {
        return if (mediaMetadata == null || type != "image") null
        else Media(
            caption = caption ?: "",
            mediaMetadata = mediaMetadata.mapNotNull { it.toMediaMetadata() },
            type = type
        )
    }
}