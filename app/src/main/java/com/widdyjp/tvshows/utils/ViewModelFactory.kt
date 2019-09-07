package com.widdyjp.tvshows.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.widdyjp.tvshows.data.repository.tvshow.TvShowRepository
import com.widdyjp.tvshows.ui.tvlist.TvListViewModel


class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private val tvShowRepository = TvShowRepository()

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvListViewModel::class.java)) {
            return TvListViewModel(tvShowRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}