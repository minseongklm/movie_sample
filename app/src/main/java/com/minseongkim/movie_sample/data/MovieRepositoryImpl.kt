package com.minseongkim.movie_sample.data

import com.minseongkim.movie_sample.data.local.LocalDatasource
import com.minseongkim.movie_sample.data.model.Section
import com.minseongkim.movie_sample.data.network.RemoteDatasource
import com.minseongkim.movie_sample.presentation.model.Movie
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

    override fun getMoviesByComing(): Flow<List<Movie>> = flow {
        // Todo: first, try get movies data from local but if it null, request remote data.
        // Todo: create remote -> local wrapper
//        val remoteData = remoteDatasource.getMoviesByComing().toUiModel(Section.UPCOMING)
//        emit(remoteData)
        emit(upcomingMock)
    }

    override fun getMoviesByPopular(): Flow<List<Movie>> = flow {
        emit(popularMock)
    }

    override fun getMoviesByRate(): Flow<List<Movie>> = flow {
        emit(topRatingMock)
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

val upcomingMock = listOf<Movie>(
    Movie(1, "no have image", Section.UPCOMING.name),
    Movie(2, "no have image", Section.UPCOMING.name),
    Movie(3, "no have image", Section.UPCOMING.name),
    Movie(4, "no have image", Section.UPCOMING.name),
)

val popularMock = listOf<Movie>(
    Movie(5, "no image", Section.POPULAR.name),
    Movie(6, "no image", Section.POPULAR.name),
    Movie(7, "no image", Section.POPULAR.name),
    Movie(8, "no image", Section.POPULAR.name),
    Movie(9, "no image", Section.POPULAR.name),
)

val topRatingMock = listOf<Movie>(
    Movie(10, "yes image", Section.RATE.name),
    Movie(11, "yes image", Section.RATE.name),
    Movie(12, "yes image", Section.RATE.name),
    Movie(13, "yes image", Section.RATE.name),
    Movie(14, "yes image", Section.RATE.name),
)