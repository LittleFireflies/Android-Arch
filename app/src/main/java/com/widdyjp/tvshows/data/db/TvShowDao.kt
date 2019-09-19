package com.widdyjp.tvshows.data.db

import androidx.room.*
import com.widdyjp.tvshows.data.model.TvModel

@Dao
interface TvShowDao {

    @Query("SELECT * from tvshow")
    fun getFavoriteTvShows(): List<TvModel>

    @Query("SELECT * from tvshow WHERE id = :id")
    fun getFavoriteById(id: Int): TvModel?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteTvShow(tvModel: TvModel)

    @Delete
    fun removeFavoriteTvShow(tvModel: TvModel)
}