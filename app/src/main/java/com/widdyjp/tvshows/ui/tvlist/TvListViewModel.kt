package com.widdyjp.tvshows.ui.tvlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.repository.tvshow.TvShowRepository

class TvListViewModel(private val tvShowRepository: TvShowRepository) : ViewModel() {

    var tvShows: LiveData<List<TvModel>>

    init {
        tvShows = tvShowRepository.getTvShows()
    }

    fun getTvShows() {
        tvShows = tvShowRepository.getTvShows()
    }
}