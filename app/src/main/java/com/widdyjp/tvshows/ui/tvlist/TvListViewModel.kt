package com.widdyjp.tvshows.ui.tvlist

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.widdyjp.tvshows.data.db.TvShowDatabase
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.repository.tvshow.TvShowRepository

class TvListViewModel(context: Context) : ViewModel() {

    private val tvShowRepository: TvShowRepository

    var tvShows = MutableLiveData(listOf<TvModel>())

    init {
        val tvShowDao = TvShowDatabase.getDatabase(context).tvShowDao()
        tvShowRepository = TvShowRepository(tvShowDao)
    }

    fun getTvShows() {
        tvShows = tvShowRepository.getTvShows()
    }
}