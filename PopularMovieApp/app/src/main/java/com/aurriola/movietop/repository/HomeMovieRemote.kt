package com.aurriola.movietop.repository

import com.aurriola.movietop.adapter.model.PopularResponse
import com.aurriola.movietop.network.MovieClient
import io.reactivex.Observable

class HomeMovieRemote : IDataSourceRepository {
    override fun fetchMovie(query_movie: String): Observable<PopularResponse> {
        return MovieClient.gitHubService.getQueryMovie(query_movie)
    }

    override fun movieReponse(repos: PopularResponse) {
    }
}