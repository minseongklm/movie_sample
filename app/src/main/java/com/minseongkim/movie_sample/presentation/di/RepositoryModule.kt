package com.minseongkim.movie_sample.presentation.di

import com.minseongkim.movie_sample.data.MovieRepository
import com.minseongkim.movie_sample.data.MovieRepositoryImpl
import com.minseongkim.movie_sample.data.local.LocalDatasource
import com.minseongkim.movie_sample.data.network.RemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    /**
     * Dependency Inject in [MovieRepository] Use Binds.
     */
    @Provides
    @Singleton
    fun provideMovieRepository(
        localDatasource: LocalDatasource,
        remoteDatasource: RemoteDatasource,
    ): MovieRepository {
        return MovieRepositoryImpl(
            localDatasource,
            remoteDatasource,
        )
    }
}