package com.minseongkim.movie_sample.data.network

import com.minseongkim.movie_sample.BuildConfig.TMDB_API_KEY
import com.minseongkim.movie_sample.data.model.ActorRemote
import com.minseongkim.movie_sample.data.model.MovieRemote
import com.minseongkim.movie_sample.data.model.MovieRemoteDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * request GET movies.
 */
interface MovieService {

    /**
     * Get Upcoming movies
     */
    @GET("/${MovieApi.SHARED_URL}/upcoming?api_key=${TMDB_API_KEY}")
    suspend fun getMoviesByUpComing(): Response<List<MovieRemote>>

    /**
     * Get Popular movies
     */
    @GET("/${MovieApi.SHARED_URL}/popular?api_key=${TMDB_API_KEY}")
    suspend fun getMoviesByPopular(): Response<List<MovieRemote>>

    /**
     * Get Top rating movies
     */
    @GET("/${MovieApi.SHARED_URL}/top_rated?api_key=${TMDB_API_KEY}")
    suspend fun getMoviesByTopRating(): Response<List<MovieRemote>>

    /**
     * Get Movie detail
     *
     * @param movieId movie id
     */
    @GET("/${MovieApi.SHARED_URL}/{movie_id}?api_key=${TMDB_API_KEY}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: Int): Response<MovieRemoteDetail>

    /**
     * Get appear actor in movie
     *
     * @param movieId movie id
     */
    @GET("/${MovieApi.SHARED_URL}/{movie_id}/credits?api_key=${TMDB_API_KEY}")
    suspend fun getMovieActor(@Path("movie_id") movieId: Int): Response<ActorRemote>
}