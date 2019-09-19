package com.widdyjp.tvshows.ui.tvdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.utils.dateFormatter
import kotlinx.android.synthetic.main.activity_tv_detail.*

class TvDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "EXTRA_TV"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_detail)

        val tv = intent.getParcelableExtra<TvModel>(EXTRA_TV)
        if (tv != null) {
            Glide.with(this).load("https://image.tmdb.org/t/p/w500${tv.backdropPath}")
                .into(ivBackdrop)
            Glide.with(this).load("https://image.tmdb.org/t/p/w500${tv.posterPath}").into(ivPoster)
            tvTitle.text = tv.name
            tvFirstAir.text = dateFormatter(tv.firstAirDate)
            tvRating.text = "${tv.voteAverage}/10"
            tvOverview.text = tv.overview
        }
    }
}
