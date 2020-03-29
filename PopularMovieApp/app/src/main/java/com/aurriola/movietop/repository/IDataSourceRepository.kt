package com.aurriola.movietop.repository

import com.aurriola.movietop.adapter.model.PopularResponse
import io.reactivex.Observable

interface IDataSourceRepository {
    fun fetchMovie(query_movie:String):Observable<PopularResponse>

    fun movieReponse(repos: PopularResponse)

}