package com.minseongkim.movie_sample.data.datasource

import com.minseongkim.movie_sample.data.local.MovieDao
import javax.inject.Inject

/**
 * Datasource from local data.
 */
class LocalDatasource @Inject constructor(private val dao: MovieDao) {
}