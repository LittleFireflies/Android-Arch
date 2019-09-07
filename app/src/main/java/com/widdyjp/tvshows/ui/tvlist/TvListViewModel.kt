package com.widdyjp.tvshows.ui.tvlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.repository.TvShowRepository

class TvListViewModel(private val tvShowRepository: TvShowRepository) : ViewModel() {

    private var tvShows = MutableLiveData<List<TvModel>>()

    fun getTvShows(): LiveData<List<TvModel>> {
        tvShows = tvShowRepository.getTvShows() as MutableLiveData<List<TvModel>>
        return tvShows
    }
}