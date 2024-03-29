package com.widdyjp.tvshows.ui.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.data.model.TvModel
import kotlinx.android.synthetic.main.item_tv_list.view.*

class FavoriteTvAdapter(val clickListener: (TvModel) -> Unit) :
    RecyclerView.Adapter<FavoriteTvAdapter.ViewHolder>() {

    var tvList = listOf<TvModel>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_tv_list, parent, false
        )
    )

    override fun getItemCount(): Int = tvList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(tvList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(tv: TvModel) {
            itemView.tvTitle.text = tv.name
            Glide.with(itemView).load("https://image.tmdb.org/t/p/w500${tv.posterPath}")
                .into(itemView.ivPoster)
            itemView.setOnClickListener { clickListener(tv) }
        }
    }
}