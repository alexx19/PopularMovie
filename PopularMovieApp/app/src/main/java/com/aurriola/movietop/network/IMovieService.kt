package com.aurriola.movietop.network

import com.aurriola.movietop.adapter.model.PopularMoviewModel
import com.aurriola.movietop.adapter.model.PopularResponse
import com.aurriola.movietop.utils.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET

interface IMovieService {
    @GET("movie/popular?api_key=${ API_KEY }")
    fun getPopularMovie(): Observable<PopularResponse>
}