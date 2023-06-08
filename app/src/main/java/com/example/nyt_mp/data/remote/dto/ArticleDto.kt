package com.example.nyt_mp.data.remote.dto

import com.example.nyt_mp.domain.model.Article
import com.google.gson.annotations.SerializedName

data class ArticleDto(
    @SerializedName("abstract")
    val abstract: String? = null,
    @SerializedName("adx_keywords")
    val adxKeywords: String? = null,
    @SerializedName("asset_id")
    val assetId: Long? = null,
    @SerializedName("byline")
    val byLine: String? = null,
    @SerializedName("column")
    val column: Any? = null,
    @SerializedName("des_facet")
    val desFacet: List<String>? = null,
    @SerializedName("eta_id")
    val etaId: Int? = null,
    @SerializedName("geo_facet")
    val geoFacet: List<String>? = null,
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("media")
    val media: List<MediaDto>? = null,
    @SerializedName("nytdsection")
    val nytSection: String? = null,
    @SerializedName("org_facet")
    val orgFacet: List<String>? = null,
    @SerializedName("per_facet")
    val perFacet: List<String>? = null,
    @SerializedName("published_date")
    val publishedDate: String? = null,
    @SerializedName("section")
    val section: String? = null,
    @SerializedName("source")
    val source: String? = null,
    @SerializedName("subsection")
    val subSection: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("updated")
    val updated: String? = null,
    @SerializedName("uri")
    val uri: String? = null,
    @SerializedName("url")
    val url: String? = null,
) {
    fun toArticle(): Article? {
        return if (abstract == null || byLine == null || id == null || publishedDate == null || title == null || media == null) null
        else Article(
            abstract = abstract,
            byLine = byLine,
            desFacet = desFacet ?: emptyList(),
            geoFacet = geoFacet ?: emptyList(),
            id = id,
            media = media.mapNotNull { it.toMedia() },
            publishedDate = publishedDate,
            section = section ?: "",
            subSection = subSection ?: "",
            title = title,
            updated = updated ?: "",
            url = url ?: ""
        )
    }
}