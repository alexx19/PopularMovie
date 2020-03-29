package com.aurriola.movietop.adapter.model

import com.google.gson.annotations.SerializedName

data class VideoResult (
    val id: String,
    @SerializedName("iso_639_1")
    val iso639_1: String,
    @SerializedName("iso_3166_1")
    val iso3166_1: String,
    val key: String,
    val name: String,
    val site: String,
    val size: Long,
    val type: String
)
