package com.aurriola.movietop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aurriola.movietop.R
import com.aurriola.movietop.utils.URL_IMG
import com.aurriola.movietop.viewmodel.OverviewViewModel
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_overview_movie.*
import kotlinx.android.synthetic.main.activity_overview_movie.view.*

class OverviewMovieActivity : AppCompatActivity() {

    private var TAG = "OverviewMovieActivity"

    private lateinit var  overviewMovieViewModel: OverviewViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview_movie)

        //Se obtiene el valor pasado por el intent
        val movie_id = intent.getLongExtra("movie_id", 0)
        Log.d(TAG, "===> "+ movie_id)

        overviewMovieViewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)

        getMovieDetail(movie_id)
        observableMovieDetail()
    }


    private fun getMovieDetail(movieId: Long) {
        overviewMovieViewModel.getMovieDetails(movieId)
    }


    private fun observableMovieDetail() {
       overviewMovieViewModel.getMovieDetailLiveData().observe(this,
       Observer {
           response ->
           txtTitle.text = response.title
           txtRealese.text = response.releaseDate
           txtOverview.text = response.overview
           txtGenres.text = response.genres[0].name
           overviewMovieViewModel.loadImage(img_cartel, response.posterPath)
       })
    }
}
