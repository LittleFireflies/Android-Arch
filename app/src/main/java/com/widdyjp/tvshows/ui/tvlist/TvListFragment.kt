package com.widdyjp.tvshows.ui.tvlist

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
import kotlinx.android.synthetic.main.fragment_tv_list.*
import org.jetbrains.anko.support.v4.startActivity

class TvListFragment : Fragment() {

    private lateinit var viewModel: TvListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tv_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = obtainViewModel(activity!!)
        val adapter = TvListAdapter { tv ->
            startActivity<TvDetailActivity>(TvDetailActivity.EXTRA_TV to tv)
        }
        val layoutManager = GridLayoutManager(context, 2)
        rvTv.adapter = adapter
        rvTv.layoutManager = layoutManager

        viewModel.getTvShows()

        viewModel.tvShows.observe(this, Observer { tvShows ->
            adapter.tvList = tvShows
        })
    }

    private fun obtainViewModel(activity: FragmentActivity): TvListViewModel {
        val factory = ViewModelFactory(activity)
        return ViewModelProviders.of(activity, factory).get(TvListViewModel::class.java)
    }

}
