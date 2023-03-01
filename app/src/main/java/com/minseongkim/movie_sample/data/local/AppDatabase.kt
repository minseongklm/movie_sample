package com.minseongkim.movie_sample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.minseongkim.movie_sample.data.model.ActorLocal
import com.minseongkim.movie_sample.data.model.MovieLocal

/**
 * Room database for local movie data.
 */
@Database(entities = [MovieLocal::class, ActorLocal::class], version = 1, exportSchema = false)
@TypeConverters(value = [GenreTypeConverter::class, ActorTypeConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun actorDao(): ActorDao
}