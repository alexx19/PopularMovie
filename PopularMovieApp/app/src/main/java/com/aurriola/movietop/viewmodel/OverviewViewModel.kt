package com.aurriola.movietop.viewmodel

import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aurriola.movietop.adapter.model.MovieDetailResponse
import com.aurriola.movietop.network.MovieClient
import com.aurriola.movietop.utils.URL_IMG
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_overview_movie.*

class OverviewViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val movieDetail = MutableLiveData<MovieDetailResponse>()


    fun getMovieDetails(movie_id: Long) {
        val disposableMovieDetail = MovieClient.getGitHubServices().getMovieDetail(movie_id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                movieDetail.value = response
            }
        compositeDisposable.add(disposableMovieDetail)
    }

    fun loadImage(imageView: ImageView, url:String)
    {
        Picasso.get().load(URL_IMG + url).into(imageView);
    }

    fun getMovieDetailLiveData(): LiveData<MovieDetailResponse> = movieDetail


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}