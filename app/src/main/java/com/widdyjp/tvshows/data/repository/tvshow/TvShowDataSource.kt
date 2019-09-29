package com.widdyjp.tvshows.data.repository.tvshow

import androidx.lifecycle.MutableLiveData
import com.widdyjp.tvshows.data.model.TvModel

interface TvShowDataSource {
    fun getTvShows(): MutableLiveData<List<TvModel>>

    // Database
    fun addFavoriteTv(tvModel: TvModel)

    fun getFavoriteTvShow(): List<TvModel>
    fun getFavoriteTvShowById(id: Int): TvModel?
    fun removeFavoriteTvShow(tvModel: TvModel)
}