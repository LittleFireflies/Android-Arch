package com.widdyjp.tvshows.ui.tvdetail

import android.content.Context
import androidx.lifecycle.ViewModel
import com.widdyjp.tvshows.data.db.TvShowDatabase
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.repository.tvshow.TvShowRepository

class TvDetailViewModel(context: Context) : ViewModel() {

    private val tvShowRepository: TvShowRepository

    init {
        val tvShowDao = TvShowDatabase.getDatabase(context).tvShowDao()
        tvShowRepository = TvShowRepository(tvShowDao)
    }

    fun isFavorite(id: Int): Boolean {
        return tvShowRepository.getFavoriteTvShowById(id) != null
    }

    fun addToFavorite(tv: TvModel) {
        tvShowRepository.addFavoriteTv(tv)
    }

    fun removeFavorite(tv: TvModel) {
        tvShowRepository.removeFavoriteTvShow(tv)
    }
}