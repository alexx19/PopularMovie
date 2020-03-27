package com.aurriola.movietop.adapter.model

import com.google.gson.annotations.SerializedName

data class PopularResponse (
    val page: Long,

    @SerializedName("total_results")
    val totalResults: Long,

    @SerializedName("total_pages")
    val totalPages: Long,

    val results: List<PopularMoviewModel>
)