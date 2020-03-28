package com.aurriola.movietop.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.aurriola.movietop.R
import com.aurriola.movietop.adapter.model.PopularMoviewModel
import com.aurriola.movietop.utils.URL_IMG
import com.aurriola.movietop.utils.UtilsCommons
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_movie.view.*

class PopularMovieAdapter: RecyclerView.Adapter<PopularMovieAdapter.StarRepoViewHolder>() {

    val popularResponses= ArrayList<PopularMoviewModel>()

    class StarRepoViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val title = view.txt_title
        //val description = view.txt_description
        //val realese_date =  view.txt_date
        val iv_poster = view.iv_poster


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StarRepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_movie,parent, false )
        return StarRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
       return popularResponses.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: StarRepoViewHolder, position: Int) {

        holder.title.text = popularResponses[position].title
       // holder.description.text = popularResponses[position].overview
       // holder.realese_date.text = popularResponses[position].releaseDate
       // holder.realese_date.text = UtilsCommons().convertDate(popularResponses[position].releaseDate)
            Picasso.get().load(URL_IMG+popularResponses[position].backdropPath).into(holder.iv_poster);
    }

    public  fun addPopularMoview(arrayRepo: List<PopularMoviewModel>)
    {
        popularResponses.addAll(arrayRepo)
        notifyDataSetChanged()

    }

}