package com.widdyjp.tvshows.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.ui.tvdetail.TvDetailActivity
import com.widdyjp.tvshows.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_favorite_tv.*
import org.jetbrains.anko.support.v4.startActivity

class FavoriteTvFragment : Fragment() {

    private lateinit var viewModel: FavoriteTvViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorite_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = obtainViewModel(activity!!)

        val adapter = FavoriteTvAdapter { tv ->
            startActivity<TvDetailActivity>(TvDetailActivity.EXTRA_TV to tv)
        }
        val layoutManager = GridLayoutManager(context, 2)
        rvFavorite.adapter = adapter
        rvFavorite.layoutManager = layoutManager

        viewModel.getFavoriteTvShows()

        viewModel.tvShows.observe(this, Observer { tvShows ->
            adapter.tvList = tvShows
        })
    }

    private fun obtainViewModel(activity: FragmentActivity): FavoriteTvViewModel {
        val factory = ViewModelFactory(activity)
        return ViewModelProviders.of(activity, factory).get(FavoriteTvViewModel::class.java)
    }
}
