package com.widdyjp.tvshows.ui.tvdetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.utils.ViewModelFactory
import com.widdyjp.tvshows.utils.dateFormatter
import kotlinx.android.synthetic.main.activity_tv_detail.*
import org.jetbrains.anko.imageResource

class TvDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV = "EXTRA_TV"
    }

    private lateinit var viewModel: TvDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_detail)

        viewModel = obtainViewModel(this)

        val tv = intent.getParcelableExtra<TvModel>(EXTRA_TV)
        if (tv != null) {
            Glide.with(this).load("https://image.tmdb.org/t/p/w500${tv.backdropPath}")
                .into(ivBackdrop)
            Glide.with(this).load("https://image.tmdb.org/t/p/w500${tv.posterPath}").into(ivPoster)
            tvTitle.text = tv.name
            tvFirstAir.text = dateFormatter(tv.firstAirDate)
            tvRating.text = "${tv.voteAverage}/10"
            tvOverview.text = tv.overview
            displayFavoriteStatus(viewModel.isFavorite(tv.id))

            ivFavorite.setOnClickListener {
                if (viewModel.isFavorite(tv.id)) {
                    viewModel.removeFavorite(tv)
                    Toast.makeText(this, "Favorite removed", Toast.LENGTH_SHORT).show()
                } else {
                    viewModel.addToFavorite(tv)
                    Toast.makeText(this, "Insert success", Toast.LENGTH_SHORT).show()
                }
                displayFavoriteStatus(viewModel.isFavorite(tv.id))
            }
        }


    }

    private fun displayFavoriteStatus(favorite: Boolean) {
        if (favorite) {
            ivFavorite.imageResource = R.drawable.ic_favorite
        } else {
            ivFavorite.imageResource = R.drawable.ic_not_favorite
        }
    }

    private fun obtainViewModel(activity: FragmentActivity): TvDetailViewModel {
        val factory = ViewModelFactory(activity)
        return ViewModelProviders.of(activity, factory).get(TvDetailViewModel::class.java)
    }
}
