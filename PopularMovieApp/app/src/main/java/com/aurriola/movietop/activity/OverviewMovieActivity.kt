package com.aurriola.movietop.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aurriola.movietop.R
import com.aurriola.movietop.adapter.TrailerListAdapter
import com.aurriola.movietop.viewmodel.OverviewViewModel
import kotlinx.android.synthetic.main.activity_overview_movie.*

class OverviewMovieActivity : AppCompatActivity() {

    private var TAG = "OverviewMovieActivity"

    private lateinit var overviewMovieViewModel: OverviewViewModel

    private lateinit var trailerListAdapter: TrailerListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overview_movie)
        val linnerManagerTrailer =
            LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        recly_trailer.layoutManager = linnerManagerTrailer

        //Se obtiene el valor pasado por el intent
        val movie_id = intent.getLongExtra("movie_id", 0)
        Log.d(TAG, "===> " + movie_id)

        overviewMovieViewModel = ViewModelProviders.of(this).get(OverviewViewModel::class.java)
        trailerListAdapter = TrailerListAdapter()

        recly_trailer.adapter = trailerListAdapter


        getMovieDetail(movie_id)
        observableMovieDetail()

        getMovieTrailer(movie_id)
        observableMovieTrailer()


        /*trailerListAdapter.onItemClick{
            itemResp ->
            Log.d(TAG,itemResp.id+"")
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=")))
        }*/

        trailerListAdapter.onItemClick = { videoItemResp ->
            Log.d(TAG, videoItemResp.id)
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=${videoItemResp.key}")
                )
            )
        }

    }


    private fun getMovieTrailer(movieId: Long) {
        overviewMovieViewModel.getMovieTrailers(movieId)
    }


    private fun getMovieDetail(movieId: Long) {
        overviewMovieViewModel.getMovieDetails(movieId)
    }


    private fun observableMovieDetail() {
        overviewMovieViewModel.getMovieDetailLiveData().observe(this,
            Observer { response ->
                txtTitle.text = response.title
                txtRealese.text = response.releaseDate
                txtOverview.text = response.overview
                txtGenres.text = response.genres[0].name
                overviewMovieViewModel.loadImage(img_cartel, response.posterPath)
            })
    }


    private fun observableMovieTrailer() {
        overviewMovieViewModel.getMovieTrailerLiveData().observe(this, Observer { response ->
            trailerListAdapter.setAllTrailerLink(response.results)
        })
    }

}
