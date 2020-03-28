package com.aurriola.movietop.network

import com.aurriola.movietop.adapter.model.PopularResponse
import com.aurriola.movietop.utils.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET

interface IMovieService {
    @GET("movie/popular?api_key=${ API_KEY }")
    fun getPopularMovie(): Observable<PopularResponse>

    @GET("movie/top_rated?api_key=${ API_KEY }")
    fun getTopRated(): Observable<PopularResponse>

    @GET("movie/upcoming?api_key=${ API_KEY }")
    fun getUpcoming(): Observable<PopularResponse>
}