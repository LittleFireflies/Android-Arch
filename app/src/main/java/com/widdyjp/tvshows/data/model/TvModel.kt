package com.widdyjp.tvshows.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvModel(
    @field:Json(name = "id")
    var id: Int = 0,
    @field:Json(name = "name")
    var name: String = "",
    @field:Json(name = "overview")
    var overview: String = "",
    @field:Json(name = "first_air_date")
    var firstAirDate: String = "",
    @field:Json(name = "backdrop_path")
    var backdropPath: String = "",
    @field:Json(name = "poster_path")
    var posterPath: String = "",
    @field:Json(name = "vote_average")
    var voteAverage: Double = 0.0
) : Parcelable