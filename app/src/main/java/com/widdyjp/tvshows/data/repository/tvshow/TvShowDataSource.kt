package com.widdyjp.tvshows.data.repository.tvshow

import androidx.lifecycle.LiveData
import com.widdyjp.tvshows.data.model.TvModel

interface TvShowDataSource {
    fun getTvShows(): LiveData<List<TvModel>>

    // Database
    fun addFavoriteTv(tvModel: TvModel)
    fun getFavoriteTvShow(): LiveData<List<TvModel>>
    fun getFavoriteTvShowById(id: Int): TvModel?
    fun removeFavoriteTvShow(tvModel: TvModel)
}