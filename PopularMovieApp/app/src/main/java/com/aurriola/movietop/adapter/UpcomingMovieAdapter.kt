package com.aurriola.movietop.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.aurriola.movietop.R
import com.aurriola.movietop.adapter.model.PopularMovieModel
import com.aurriola.movietop.utils.URL_IMG
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_popular.view.iv_poster
import kotlinx.android.synthetic.main.row_popular.view.txt_title
import kotlinx.android.synthetic.main.row_upcoming.view.*

class UpcomingMovieAdapter: RecyclerView.Adapter<UpcomingMovieAdapter.StarRepoViewHolder>() {

    val popularResponses= ArrayList<PopularMovieModel>()

    var onItemClick: ((PopularMovieModel) -> Unit)? = null

    inner class StarRepoViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val title = view.txt_title
        //val description = view.txt_description
        val realese_date =  view.txt_release_date
        val iv_poster = view.iv_poster


        init {
            view.setOnClickListener {
                onItemClick?.invoke(popularResponses[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_upcoming,parent, false )
        return StarRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularResponses.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: StarRepoViewHolder, position: Int) {

        holder.title.text = popularResponses[position].title
         holder.realese_date.text = popularResponses[position].releaseDate
        Picasso.get().load(URL_IMG+popularResponses[position].backdropPath).into(holder.iv_poster);
    }

    fun addPopularMoview(arrayRepo: List<PopularMovieModel>)
    {
        popularResponses.addAll(arrayRepo)
        notifyDataSetChanged()

    }

}