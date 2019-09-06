package com.widdyjp.tvshows.data.model

data class TvModel(
    var id: Int = 0,
    var name: String = "",
    var overview: String = "",
    var first_air_date: String = "",
    var backdrop_path: String = "",
    var poster_path: String = "",
    var vote_average: Double = 0.0
)