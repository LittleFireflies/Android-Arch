package com.widdyjp.tvshows.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.widdyjp.tvshows.data.model.TvModel

@Database(entities = [TvModel::class], version = 1)
abstract class TvShowDatabase : RoomDatabase() {

    abstract fun tvShowDao(): TvShowDao

    companion object {
        @Volatile
        private var INSTANCE: TvShowDatabase? = null

        fun getDatabase(context: Context): TvShowDatabase {
            val tmpInstance = INSTANCE
            if (tmpInstance != null) {
                return tmpInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TvShowDatabase::class.java,
                    "tvshowdb"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}