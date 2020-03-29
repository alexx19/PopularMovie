package com.aurriola.movietop.network

import com.aurriola.movietop.adapter.model.PopularResponse
import com.aurriola.movietop.utils.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IMovieService {
    @GET("movie/{query_movie}?api_key=${ API_KEY }")
    fun getQueryMovie(@Path("query_movie") query_movie:String): Observable<PopularResponse>
}