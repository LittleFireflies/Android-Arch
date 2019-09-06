package com.widdyjp.tvshows.ui.tvlist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.data.model.getDummyTvShows
import kotlinx.android.synthetic.main.activity_tv_list.*

class TvListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_list)

        val adapter = TvListAdapter(getDummyTvShows())
        val layoutManager = GridLayoutManager(this, 2)
        rvTv.adapter = adapter
        rvTv.layoutManager = layoutManager
    }
}
