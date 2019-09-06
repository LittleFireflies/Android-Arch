package com.widdyjp.tvshows.data.network

import com.widdyjp.tvshows.data.model.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("3/discover/tv")
    fun discoverTvShows(@Query("api_key") apiKey: String): Call<TvResponse>
}