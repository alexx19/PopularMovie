package com.aurriola.movietop.network

import com.aurriola.movietop.adapter.model.MovieDetailResponse
import com.aurriola.movietop.adapter.model.PopularResponse
import com.aurriola.movietop.adapter.model.VideoLinkResponse
import com.aurriola.movietop.utils.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface IMovieService {

    @GET("movie/{query_movie}?api_key=${ API_KEY }")
    fun getQueryMovie(@Path("query_movie") query_movie:String): Observable<PopularResponse>

    @GET("movie/{movie_id}?api_key=${ API_KEY }")
    fun getMovieDetail(@Path("movie_id") movie_id: Long): Observable<MovieDetailResponse>

    @GET("movie/{movie_id}/videos?api_key=${ API_KEY }")
    fun getVideoLink(@Path("movie_id" ) movie_id: Long ): Observable<VideoLinkResponse>

}