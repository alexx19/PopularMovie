package com.aurriola.movietop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aurriola.movietop.adapter.PopularMovieAdapter
import com.aurriola.movietop.adapter.TopRatedMovieAdapter
import com.aurriola.movietop.adapter.UpcomingMovieAdapter
import com.aurriola.movietop.adapter.model.PopularMoviewModel
import com.aurriola.movietop.network.MovieClient
import com.aurriola.movietop.viewmodel.HomeMovieViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var topRatedMovieAdapter: TopRatedMovieAdapter
    private lateinit var popularMoviewModel: PopularMovieAdapter
    private lateinit var upcomingMovieAdapter: UpcomingMovieAdapter

    private lateinit var homeMovieViewModel: HomeMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linnerManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        val linnerManagerTrending =
            LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        val linnerManagerUpcoming =
            LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)

        list_popular.layoutManager = linnerManager
        list_trending.layoutManager = linnerManagerTrending
        list_upcoming.layoutManager = linnerManagerUpcoming

        topRatedMovieAdapter = TopRatedMovieAdapter()
        popularMoviewModel = PopularMovieAdapter()
        upcomingMovieAdapter = UpcomingMovieAdapter()


        list_popular.adapter = topRatedMovieAdapter
        list_trending.adapter = popularMoviewModel
        list_upcoming.adapter = upcomingMovieAdapter

        homeMovieViewModel = ViewModelProviders.of(this).get(HomeMovieViewModel::class.java)

        getTopRated()
        observerTopRated()

        getTrending()
        observerTrending()

        getUpcoming()
        observerUpcoming()
    }

    private fun getTopRated() {
        homeMovieViewModel.getTopRated()
    }

    private fun observerTopRated() {
        homeMovieViewModel.getTopRatedLiveData().observe(this, Observer { response ->
            topRatedMovieAdapter.addPopularMoview(response.results)
        })
    }


    private fun getTrending() {
        homeMovieViewModel.getTrending()
    }

    @SuppressLint("CheckResult")
    private fun observerTrending() {
        homeMovieViewModel.getTrendingLiveData().observe(this, Observer {
            response -> popularMoviewModel.addPopularMoview(response.results)
        })
    }

    private fun observerUpcoming() {
        homeMovieViewModel.getUpcoming()
    }


     @SuppressLint("CheckResult")
   private fun getUpcoming(){
       homeMovieViewModel.getUpcomingLiveData().observe(this, Observer {
           response -> upcomingMovieAdapter.addPopularMoview(response.results)
       })
   }
}
