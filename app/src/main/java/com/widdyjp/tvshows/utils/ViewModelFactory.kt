package com.widdyjp.tvshows.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.widdyjp.tvshows.ui.favorite.FavoriteTvViewModel
import com.widdyjp.tvshows.ui.tvdetail.TvDetailViewModel
import com.widdyjp.tvshows.ui.tvlist.TvListViewModel


class ViewModelFactory(private val activity: FragmentActivity) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
        when {
            modelClass.isAssignableFrom(TvListViewModel::class.java) -> return TvListViewModel(
                activity
            ) as VM
            modelClass.isAssignableFrom(TvDetailViewModel::class.java) -> return TvDetailViewModel(
                activity
            ) as VM
            modelClass.isAssignableFrom(FavoriteTvViewModel::class.java) -> return FavoriteTvViewModel(
                activity
            ) as VM
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }

    }
}