package com.minseongkim.movie_sample.data.repository

import com.minseongkim.movie_sample.data.datasource.LocalDatasource
import com.minseongkim.movie_sample.data.datasource.RemoteDatasource
import com.minseongkim.movie_sample.domain.repository.MovieRepository
import javax.inject.Inject

/**
 * [MovieRepositoryImpl] is Implements of [MovieRepository].
 *
 * get datasource by local and remote.
 */
class MovieRepositoryImpl @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDatasource: RemoteDatasource
) : MovieRepository {
}