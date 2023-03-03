package com.minseongkim.movie_sample.data

import com.minseongkim.movie_sample.data.local.LocalDatasource
import com.minseongkim.movie_sample.data.model.Section
import com.minseongkim.movie_sample.data.network.RemoteDatasource
import com.minseongkim.movie_sample.data.wrapper.wrapToMovies
import com.minseongkim.movie_sample.data.wrapper.wrapUiModel
import com.minseongkim.movie_sample.presentation.model.Movie
import com.minseongkim.movie_sample.presentation.model.Movies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * [MovieRepositoryImpl] is Implements of [MovieRepository].
 *
 * get datasource by local and remote.
 */
class MovieRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDatasource: RemoteDatasource,
) : MovieRepository {

    override fun getMoviesByComing(): Flow<Movies> = flow {
        // Todo: first, try get movies data from local but if it null, request remote data.
        // Todo: create remote -> local wrapper
        val remoteMovie = remoteDatasource.getMoviesByComing().wrapUiModel(Section.UPCOMING)
        val remoteMovies = remoteMovie.wrapToMovies(Section.UPCOMING)
        emit(remoteMovies)
//        emit(upcomingMock)
    }

    override fun getMoviesByPopular(): Flow<Movies> = flow {
        val remoteMovie = remoteDatasource.getMoviesByPopular().wrapUiModel(Section.POPULAR)
        val remoteMovies = remoteMovie.wrapToMovies(Section.POPULAR)
        emit(remoteMovies)
//        emit(popularMock)
    }

    override fun getMoviesByRate(): Flow<Movies> = flow {
        val remoteMovie = remoteDatasource.getMoviesByRate().wrapUiModel(Section.TOPRATE)
        val remoteMovies = remoteMovie.wrapToMovies(Section.TOPRATE)
        emit(remoteMovies)
//        emit(topRatingMock)
    }

    override fun getMovieDetail(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun getMovieCredit(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun getMovieImage(movieId: Int) {
        TODO("Not yet implemented")
    }

    override fun getMoviesBySimilar(movieId: Int) {
        TODO("Not yet implemented")
    }
}

val upcomingMock = Movies(
    section = Section.UPCOMING.name,
    movies = listOf(
        Movie(1, "/hAKPWWvUyvcfqPcoBG45c8NRr6e.jpg", Section.UPCOMING.name),
        Movie(2, "/rTcfLDlcQ78tVVUDHSFJYiodJtb.jpg", Section.UPCOMING.name),
        Movie(3, "/qhxGWVppbnwF4YuzQQtIym5z99E.jpg", Section.UPCOMING.name),
        Movie(4, "/cdFcG37dOUBX7m4zcQmx0JCn72y.jpg", Section.UPCOMING.name),
    )
)

val popularMock = Movies(
    section = Section.POPULAR.name,
    movies = listOf(
        Movie(5, "/hAKPWWvUyvcfqPcoBG45c8NRr6e.jpg", Section.POPULAR.name),
        Movie(6, "/rTcfLDlcQ78tVVUDHSFJYiodJtb.jpg", Section.POPULAR.name),
        Movie(7, "/uKvJ15U5XJuvGMx4uXmimcAd0Qt.jpg", Section.POPULAR.name),
        Movie(8, "/m4CJX4QwjZsdYJKe8OJamLRnlQh.jpg", Section.POPULAR.name),
        Movie(9, "/m4CJX4QwjZsdYJKe8OJamLRnlQh.jpg", Section.POPULAR.name),
    )
)

val topRatingMock = Movies(
    section = Section.TOPRATE.name,
    movies = listOf(
        Movie(10, "/hAKPWWvUyvcfqPcoBG45c8NRr6e.jpg", Section.TOPRATE.name),
        Movie(11, "/rTcfLDlcQ78tVVUDHSFJYiodJtb.jpg", Section.TOPRATE.name),
        Movie(12, "/uKvJ15U5XJuvGMx4uXmimcAd0Qt.jpg", Section.TOPRATE.name),
        Movie(13, "/m4CJX4QwjZsdYJKe8OJamLRnlQh.jpg", Section.TOPRATE.name),
        Movie(14, "/m4CJX4QwjZsdYJKe8OJamLRnlQh.jpg", Section.TOPRATE.name),
    )
)