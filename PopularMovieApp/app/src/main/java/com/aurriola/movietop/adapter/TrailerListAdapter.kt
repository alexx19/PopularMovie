package com.aurriola.movietop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aurriola.movietop.R
import com.aurriola.movietop.adapter.model.VideoResult
import kotlinx.android.synthetic.main.row_trailer.view.*


class TrailerListAdapter: RecyclerView.Adapter<TrailerListAdapter.TrailerListViewHolder> () {

    private val trailerResponse = ArrayList<VideoResult>()
    var onItemClick: ((VideoResult) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_trailer, parent, false)
        return TrailerListViewHolder(view)

    }

    override fun getItemCount(): Int {
       return trailerResponse.size
    }

    override fun onBindViewHolder(holder: TrailerListViewHolder, position: Int) {
        holder.txtTile.text = trailerResponse[position].name


    }

    fun setAllTrailerLink(trailerLinks: List<VideoResult>)
    {
        trailerResponse.addAll(trailerLinks)
        notifyDataSetChanged()
    }

    inner class TrailerListViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val txtTile = view.txtNameYoutube

        init {
            view.setOnClickListener {
                onItemClick?.invoke(trailerResponse[adapterPosition])
            }
        }
    }

}