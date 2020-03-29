package com.aurriola.movietop.viewmodel

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aurriola.movietop.adapter.model.PopularResponse
import com.aurriola.movietop.repository.HomeMovieRemote
import com.aurriola.movietop.repository.HomeRepository
import com.aurriola.movietop.utils.POPULAR
import com.aurriola.movietop.utils.TOPRATED
import com.aurriola.movietop.utils.UPCOMING
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeMovieViewModel : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val topRatedMovie = MutableLiveData<PopularResponse>()
    private val trendingMovie = MutableLiveData<PopularResponse>()
    private val upcomingMovie = MutableLiveData<PopularResponse>()

    val homeRepository = HomeRepository(HomeMovieRemote())

    @SuppressLint("CheckResult")
    fun getTopRated() {
        val disposable = homeRepository
            .fetchMovie(TOPRATED)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                topRatedMovie.value = response
            }
        compositeDisposable.addAll(disposable)
    }

    @SuppressLint("CheckResult")
    fun getTrending() {
        val disposable = homeRepository
            .fetchMovie(POPULAR)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                trendingMovie.value = response
            }
        compositeDisposable.addAll(disposable)
    }

    @SuppressLint("CheckResult")
    fun getUpcoming() {
        val disposable = homeRepository
            .fetchMovie(UPCOMING)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                upcomingMovie.value = response
            }
        compositeDisposable.addAll(disposable)
    }

    //Notifican al ui, el cambio en la data.
    fun getTopRatedLiveData(): LiveData<PopularResponse> = topRatedMovie

    fun getTrendingLiveData(): LiveData<PopularResponse> = trendingMovie

    fun getUpcomingLiveData(): LiveData<PopularResponse> = upcomingMovie


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}