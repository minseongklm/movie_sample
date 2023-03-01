package com.minseongkim.movie_sample.data.local

import javax.inject.Inject

/**
 * Datasource from local data.
 */
class LocalDatasource @Inject constructor(
    private val movieDao: MovieDao,
    private val actorDao: ActorDao,
) {

}