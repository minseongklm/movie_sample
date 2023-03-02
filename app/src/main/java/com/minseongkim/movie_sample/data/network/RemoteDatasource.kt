package com.minseongkim.movie_sample.data.network

import com.minseongkim.movie_sample.data.model.MovieRemote
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Datasource from remote data.
 */
class RemoteDatasource @Inject constructor(private val service: MovieService) {


    suspend fun getMoviesByComing(): List<MovieRemote> {
        val movies = service.getMoviesByUpComing().body() ?: emptyList()
        return movieEmptyValidate(movies)
    }

    suspend fun getMoviesByPopular(): List<MovieRemote> {
        val movies = service.getMoviesByPopular().body() ?: emptyList()
        return movieEmptyValidate(movies)
    }

    suspend fun getMoviesByRate(): List<MovieRemote> {
        val movies = service.getMoviesByTopRating().body() ?: emptyList()
        return movieEmptyValidate(movies)
    }

    suspend fun getMovieDetail(movieId: Int) = flow {
        val movie = service.getMovieDetail(movieId)
        emit(movie)
    }

    suspend fun getMovieCredit(movieId: Int) = flow {
        val actors = service.getMovieActor(movieId)
        emit(actors)
    }

    suspend fun getMovieImage(movieId: Int) {
        TODO("Not yet implemented")
    }

    suspend fun getMoviesBySimilar(movieId: Int) {
        TODO("Not yet implemented")
    }

    fun movieEmptyValidate(movieList: List<MovieRemote>): List<MovieRemote> {
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            throw IllegalAccessException("Failed get remote movie data.")
        }
    }
}