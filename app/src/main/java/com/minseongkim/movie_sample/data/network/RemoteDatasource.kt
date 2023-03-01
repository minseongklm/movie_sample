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
        if (movies.isNotEmpty()) {
            return movies
        } else {
            throw IllegalStateException("Failed get remote movie data.")
        }
    }

    suspend fun getMoviesByPopular() = flow {
        val movies = service.getMoviesByPopular()
        emit(movies)
    }

    suspend fun getMoviesByRate() = flow {
        val movies = service.getMoviesByTopRating()
        emit(movies)
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

}