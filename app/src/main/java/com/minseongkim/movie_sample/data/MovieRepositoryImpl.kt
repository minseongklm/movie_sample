package com.minseongkim.movie_sample.data

import com.minseongkim.movie_sample.data.local.LocalDatasource
import com.minseongkim.movie_sample.data.model.Section
import com.minseongkim.movie_sample.data.network.RemoteDatasource
import com.minseongkim.movie_sample.data.wrapper.wrapLocalModel
import com.minseongkim.movie_sample.data.wrapper.wrapToMovies
import com.minseongkim.movie_sample.data.wrapper.wrapUiModel
import com.minseongkim.movie_sample.presentation.model.LayoutStyle
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

    override fun getMoviesByComing(section: Section): Flow<Movies> = flow {
        val localMovies =
            localDatasource.getMoviesBySection(section).wrapUiModel(LayoutStyle.TOP)
        if (localMovies.isNotEmpty() && localMovies.size > 9) {
            emit(localMovies.slice(0..9).wrapToMovies(section))
        } else {
            val response =
                remoteDatasource.getMoviesByComing()
            emit(response.wrapUiModel(section, LayoutStyle.TOP).wrapToMovies(section))
            localDatasource.insertMovies(response.wrapLocalModel(section))
        }
    }

    override fun getMoviesByPopular(section: Section): Flow<Movies> = flow {
        val localMovies =
            localDatasource.getMoviesBySection(section).wrapUiModel()
        if (localMovies.isNotEmpty()) {
            emit(localMovies.wrapToMovies(section))
        } else {
            val response =
                remoteDatasource.getMoviesByPopular()
            emit(response.wrapUiModel(section).wrapToMovies(section))
            localDatasource.insertMovies(response.wrapLocalModel(section))
        }
    }

    override fun getMoviesByRate(section: Section): Flow<Movies> = flow {
        val localMovies =
            localDatasource.getMoviesBySection(section).wrapUiModel()
        if (localMovies.isNotEmpty()) {
            emit(localMovies.wrapToMovies(section))
        } else {
            val response =
                remoteDatasource.getMoviesByRate()
            emit(response.wrapUiModel(section).wrapToMovies(section))
            localDatasource.insertMovies(response.wrapLocalModel(section))
        }
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