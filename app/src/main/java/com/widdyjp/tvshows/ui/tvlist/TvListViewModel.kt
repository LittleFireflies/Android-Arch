package com.widdyjp.tvshows.ui.tvlist

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.widdyjp.tvshows.data.db.TvShowDatabase
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.repository.tvshow.TvShowRepository

class TvListViewModel(context: Context) : ViewModel() {

    private val tvShowRepository: TvShowRepository

    var tvShows: LiveData<List<TvModel>>

    init {
        val tvShowDao = TvShowDatabase.getDatabase(context).tvShowDao()
        tvShowRepository = TvShowRepository(tvShowDao)
        tvShows = tvShowRepository.getTvShows()
    }

    fun getTvShows() {
        tvShows = tvShowRepository.getTvShows()
    }
}