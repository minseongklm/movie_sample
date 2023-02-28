package com.minseongkim.movie_sample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minseongkim.movie_sample.data.model.MovieModel

/**
 * Room database for local movie data.
 */
@Database(entities = [MovieModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}