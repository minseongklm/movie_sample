package com.minseongkim.movie_sample.data

import com.minseongkim.movie_sample.presentation.model.Movies
import kotlinx.coroutines.flow.Flow

/**
 * [MovieRepository] is repository for movie data.
 */
interface MovieRepository {

    fun getMoviesByComing(): Flow<Movies>

    fun getMoviesByPopular(): Flow<Movies>

    fun getMoviesByRate(): Flow<Movies>

    fun getMovieDetail(movieId: Int): Unit

    fun getMovieCredit(movieId: Int): Unit

    fun getMovieImage(movieId: Int): Unit

    fun getMoviesBySimilar(movieId: Int): Unit
}