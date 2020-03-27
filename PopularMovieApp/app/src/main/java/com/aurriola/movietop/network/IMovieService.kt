package com.aurriola.movietop.network

import com.aurriola.movietop.adapter.model.PopularMoviewModel
import com.aurriola.movietop.adapter.model.PopularResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface IMovieService {
    @GET("movie/popular?api_key=4190074e5f32751515e2aa531ff4d43c")
    fun getPopularMovie(): Observable<PopularResponse>
}