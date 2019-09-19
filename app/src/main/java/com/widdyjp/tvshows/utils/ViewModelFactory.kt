package com.widdyjp.tvshows.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.widdyjp.tvshows.ui.tvdetail.TvDetailViewModel
import com.widdyjp.tvshows.ui.tvlist.TvListViewModel


class ViewModelFactory(private val activity: FragmentActivity) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TvListViewModel::class.java)) {
            return TvListViewModel(activity) as T
        } else if (modelClass.isAssignableFrom(TvDetailViewModel::class.java)) {
            return TvDetailViewModel(activity) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}