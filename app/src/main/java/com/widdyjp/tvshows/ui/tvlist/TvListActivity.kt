package com.widdyjp.tvshows.ui.tvlist

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.widdyjp.tvshows.R
import com.widdyjp.tvshows.data.model.TvResponse
import com.widdyjp.tvshows.data.network.NetworkClient
import com.widdyjp.tvshows.utils.Constant
import kotlinx.android.synthetic.main.activity_tv_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_list)

        val service = NetworkClient.createNetworkService()

        service.discoverTvShows(Constant.API_KEY).enqueue(object : Callback<TvResponse> {
            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()?.results ?: mutableListOf()

                    val adapter = TvListAdapter(data)
                    val layoutManager = GridLayoutManager(this@TvListActivity, 2)
                    rvTv.adapter = adapter
                    rvTv.layoutManager = layoutManager
                } else {
                    Log.e("Response Failed", response.message())
                }
            }

        })
    }
}
