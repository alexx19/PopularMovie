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

    class StarRepoViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val title = view.txt_title
        //val description = view.txt_description
        val realese_date =  view.txt_release_date
        val iv_poster = view.iv_poster


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
        // holder.description.text = popularResponses[position].overview
         holder.realese_date.text = popularResponses[position].releaseDate
        // holder.realese_date.text = UtilsCommons().convertDate(popularResponses[position].releaseDate)
        Picasso.get().load(URL_IMG+popularResponses[position].backdropPath).into(holder.iv_poster);
    }

    public  fun addPopularMoview(arrayRepo: List<PopularMovieModel>)
    {
        popularResponses.addAll(arrayRepo)
        notifyDataSetChanged()

    }

}
    /*private val popularResponses= ArrayList<PopularMoviewModel>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view: View?
        val upComingViewHolder:UpComingViewHolder
        if (convertView == null) {
            view = View.inflate(context,R.layout.row_upcoming,null)
            upComingViewHolder = UpComingViewHolder(view)
            view.setTag(upComingViewHolder)
        }else{
            view = convertView
            upComingViewHolder = view.tag as UpComingViewHolder
        }

        upComingViewHolder.title.text = popularResponses[position].title
        upComingViewHolder.realese_date.text = popularResponses[position].releaseDate
        Picasso.get().load(URL_IMG+popularResponses[position].backdropPath).into(upComingViewHolder.iv_poster);

        return view
    }

    override fun getItem(position: Int): Any {
        return popularResponses[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return popularResponses.size
    }

    private class UpComingViewHolder(val view : View){
        val title = view.txt_title
        val realese_date =  view.txt_release_date
        val iv_poster = view.iv_poster


    }

    fun addPopularMoview(arrayRepo: List<PopularMoviewModel>)
    {
        popularResponses.addAll(arrayRepo)
        notifyDataSetChanged()

    }*/