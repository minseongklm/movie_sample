package com.minseongkim.movie_sample.data.network

import com.minseongkim.movie_sample.BuildConfig
import com.minseongkim.movie_sample.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * request GET movies.
 */
interface MovieService {
    @GET("/popular?api_key=${BuildConfig.TMDB_API_KEY}")
    suspend fun getMoviesByPopular(): Response<List<MovieModel>>
}