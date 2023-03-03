package com.minseongkim.movie_sample.data

import com.minseongkim.movie_sample.data.model.Section
import com.minseongkim.movie_sample.presentation.model.Movies
import kotlinx.coroutines.flow.Flow

/**
 * [MovieRepository] is repository for movie data.
 */
interface MovieRepository {

    fun getMoviesByComing(section: Section): Flow<Movies>

    fun getMoviesByPopular(section: Section): Flow<Movies>

    fun getMoviesByRate(section: Section): Flow<Movies>

    fun getMovieDetail(movieId: Int): Unit

    fun getMovieCredit(movieId: Int): Unit

    fun getMovieImage(movieId: Int): Unit

    fun getMoviesBySimilar(movieId: Int): Unit
}