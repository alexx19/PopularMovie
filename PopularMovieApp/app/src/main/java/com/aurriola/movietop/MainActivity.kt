package com.aurriola.movietop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aurriola.movietop.adapter.PopularMovieAdapter
import com.aurriola.movietop.adapter.TopRatedMovieAdapter
import com.aurriola.movietop.adapter.UpcomingMovieAdapter
import com.aurriola.movietop.adapter.model.PopularMoviewModel
import com.aurriola.movietop.network.MovieClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var topRatedMovieAdapter: TopRatedMovieAdapter
    private lateinit var popularMoviewModel: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter


    val repo = ArrayList<PopularMoviewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linnerManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL,false)
        val linnerManagerTrending = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL,false)
        val linnerManagerUpcoming = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL,false)

        list_popular.layoutManager = linnerManager
        list_trending.layoutManager = linnerManagerTrending
         list_upcoming.layoutManager = linnerManagerUpcoming

        topRatedMovieAdapter = TopRatedMovieAdapter()
        popularMoviewModel = PopularMovieAdapter()
        upcomingMovieAdapter = UpcomingMovieAdapter()


        list_popular.adapter = topRatedMovieAdapter
        list_trending.adapter = popularMoviewModel
        list_upcoming.adapter = upcomingMovieAdapter

        getTopRated()
        getMoviePopular()
        getUpcoming()
    }

    @SuppressLint("CheckResult")
    private fun getTopRated(){
        MovieClient.getGitHubServices()
            .getTopRated()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                topRatedMovieAdapter.addPopularMoview(response.results)
            }
    }

    @SuppressLint("CheckResult")
    private fun getMoviePopular(){
        MovieClient.getGitHubServices()

            .getPopularMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                popularMoviewModel.addPopularMoview(response.results)
            }
    }

    @SuppressLint("CheckResult")
    private fun getUpcoming(){
        MovieClient.getGitHubServices()

            .getUpcoming()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                upcomingMovieAdapter.addPopularMoview(response.results)
            }
    }
}
