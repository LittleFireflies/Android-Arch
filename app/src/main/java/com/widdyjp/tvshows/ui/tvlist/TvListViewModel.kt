package com.widdyjp.tvshows.ui.tvlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.repository.tvshow.TvShowRepository

class TvListViewModel(private val tvShowRepository: TvShowRepository) : ViewModel() {

    var tvShows = MutableLiveData<List<TvModel>>()

    init {
        getTvShows()
    }

    fun getTvShows() {
        tvShows = tvShowRepository.getTvShows() as MutableLiveData<List<TvModel>>
    }
}