package com.aurriola.movietop.repository

import com.aurriola.movietop.adapter.model.PopularResponse
import io.reactivex.Observable

class HomeRepository(val homeMovieRemote: HomeMovieRemote) : IDataSourceRepository {

    override fun fetchMovie(query_movie: String): Observable<PopularResponse> {
        return Observable.concatArray(homeMovieRemote.fetchMovie(query_movie))
            .onErrorResumeNext(Observable.empty())
    }

    override fun movieReponse(repos: PopularResponse) {
       // Observable.fromCallable { repoLocalSource.saveRepo(repos) }
    }
}