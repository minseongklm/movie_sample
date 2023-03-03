package com.minseongkim.movie_sample.data.local

import com.minseongkim.movie_sample.data.model.MovieLocal
import com.minseongkim.movie_sample.data.model.Section
import javax.inject.Inject

/**
 * Datasource from local data.
 */
class LocalDatasource @Inject constructor(
    private val movieDao: MovieDao,
    private val actorDao: ActorDao,
) {

    suspend fun insertMovies(movies: List<MovieLocal>) {
        movieDao.insertMovies(*movies.toTypedArray())
    }

    suspend fun getMoviesBySection(section: Section): List<MovieLocal> {
        return movieDao.getMoviesBySection(section.name)
    }
}