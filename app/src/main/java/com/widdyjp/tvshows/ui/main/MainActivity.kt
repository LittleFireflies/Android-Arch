package com.widdyjp.tvshows.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.ui.favorite.FavoriteTvFragment
import com.widdyjp.tvshows.ui.tvlist.TvListFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager(viewPager)
        bottomNavListener()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TvListFragment(), "Tv Shows")
        adapter.addFragment(FavoriteTvFragment(), "Favorites")
        viewPager.adapter = adapter
    }

    private fun bottomNavListener() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.action_tv -> viewPager.currentItem = 0
                R.id.action_favorite -> viewPager.currentItem = 1
            }

            true
        }
    }
}
