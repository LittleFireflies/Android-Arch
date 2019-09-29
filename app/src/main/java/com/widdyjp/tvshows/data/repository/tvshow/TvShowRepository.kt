package com.widdyjp.tvshows.data.repository.tvshow

import androidx.lifecycle.MutableLiveData
import com.widdyjp.tvshows.data.db.TvShowDao
import com.widdyjp.tvshows.data.model.TvModel
import com.widdyjp.tvshows.data.model.TvResponse
import com.widdyjp.tvshows.data.network.NetworkClient
import com.widdyjp.tvshows.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowRepository(private val tvShowDao: TvShowDao) : TvShowDataSource {
    private val service = NetworkClient.createNetworkService()

    override fun getTvShows(): MutableLiveData<List<TvModel>> {
        val liveData = MutableLiveData<List<TvModel>>()

        service.discoverTvShows(Constants.API_KEY).enqueue(object : Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                if (response.isSuccessful) {
                    liveData.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        return liveData
    }

    override fun addFavoriteTv(tvModel: TvModel) {
        tvShowDao.insertFavoriteTvShow(tvModel)
    }

    override fun getFavoriteTvShow(): List<TvModel> {
        return tvShowDao.getFavoriteTvShows()
    }

    override fun getFavoriteTvShowById(id: Int): TvModel? {
        return tvShowDao.getFavoriteById(id)
    }

    override fun removeFavoriteTvShow(tvModel: TvModel) {
        tvShowDao.removeFavoriteTvShow(tvModel)
    }
}