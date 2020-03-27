package com.aurriola.movietop.adapter.model

import com.google.gson.annotations.SerializedName

data class PopularMoviewModel(
    val popularity: Double,

    @SerializedName("vote_count")
    val voteCount: Long,

    val video: Boolean,

    @SerializedName("poster_path")
    val posterPath: String,

    val id: Long,
    val adult: Boolean,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("original_language")
    val originalLanguage: String,

    @SerializedName("original_title")
    val originalTitle: String,

    @SerializedName("genre_ids")
    val genreIDS: List<Long>,

    val title: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    val overview: String,

    @SerializedName("release_date")
    val releaseDate: String
)