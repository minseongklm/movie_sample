package com.minseongkim.movie_sample.data

import com.minseongkim.movie_sample.presentation.model.Movie
import kotlinx.coroutines.flow.Flow

/**
 * [MovieRepository] is repository for movie data.
 */
interface MovieRepository {

    fun getMoviesByComing(): Flow<List<Movie>>

    fun getMoviesByPopular(): Flow<List<Movie>>

    fun getMoviesByRate(): Flow<List<Movie>>

    fun getMovieDetail(movieId: Int): Unit

    fun getMovieCredit(movieId: Int): Unit

    fun getMovieImage(movieId: Int): Unit

    fun getMoviesBySimilar(movieId: Int): Unit
}