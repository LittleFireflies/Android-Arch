package com.widdyjp.tvshows.data.network

import com.widdyjp.tvshows.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object NetworkClient {
    fun createRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        val builder = Retrofit.Builder()
        builder.client(okHttpClient)
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())

        return builder.build()
    }

    fun createNetworkService(): NetworkService {
        return createRetrofit().create(NetworkService::class.java)
    }
}