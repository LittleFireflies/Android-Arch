package com.widdyjp.tvshows.data.repository

import androidx.lifecycle.LiveData
import com.widdyjp.tvshows.data.model.TvModel

interface TvShowDataSource {
    fun getTvShows(): LiveData<List<TvModel>>
}