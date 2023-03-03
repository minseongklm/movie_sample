package com.minseongkim.movie_sample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.minseongkim.movie_sample.data.model.MovieLocal

/**
 * handle local database by query.
 */
@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(vararg movies: MovieLocal)

    @Query("SELECT * FROM movies WHERE section LIKE :section")
    suspend fun getMoviesBySection(section: String): List<MovieLocal>
}