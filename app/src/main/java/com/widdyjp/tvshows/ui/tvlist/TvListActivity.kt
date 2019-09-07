package com.widdyjp.tvshows.ui.tvlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.utils.ViewModelFactory
import kotlinx.android.synthetic.main.activity_tv_list.*


class TvListActivity : AppCompatActivity() {

    private lateinit var viewModel: TvListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_list)

        viewModel = obtainViewModel(this)

        viewModel.getTvShows().observe(this, Observer { tvShows ->
            val adapter = TvListAdapter(tvShows)
            val layoutManager = GridLayoutManager(this, 2)
            rvTv.adapter = adapter
            rvTv.layoutManager = layoutManager
            adapter.notifyDataSetChanged()
        })
    }

    private fun obtainViewModel(activity: FragmentActivity): TvListViewModel {
        val factory = ViewModelFactory()
        return ViewModelProviders.of(activity, factory).get(TvListViewModel::class.java)
    }
}
