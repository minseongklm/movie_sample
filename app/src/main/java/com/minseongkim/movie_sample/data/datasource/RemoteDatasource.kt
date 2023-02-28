package com.minseongkim.movie_sample.data.datasource

import com.minseongkim.movie_sample.data.network.MovieService
import javax.inject.Inject

/**
 * Datasource from remote data.
 */
class RemoteDatasource @Inject constructor(private val service: MovieService) {

}