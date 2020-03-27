package com.aurriola.movietop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.aurriola.movietop.adapter.PopularMovieAdapter
import com.aurriola.movietop.adapter.model.PopularMoviewModel
import com.aurriola.movietop.network.MovieClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var popularMovieAdapter: PopularMovieAdapter

    val repo = ArrayList<PopularMoviewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linnerManager = LinearLayoutManager(applicationContext)
        list_movie.layoutManager = linnerManager


        popularMovieAdapter = PopularMovieAdapter()


        list_movie.adapter = popularMovieAdapter

        getMoviePopular()
    }

    @SuppressLint("CheckResult")
    private fun getMoviePopular(){
        MovieClient.getGitHubServices().getPopularMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                println("reponse "+response.page)
                popularMovieAdapter.addPopularMoview(response.results)
            }
    }

}
