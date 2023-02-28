package com.minseongkim.movie_sample.presentation.di

import com.minseongkim.movie_sample.data.repository.MovieRepositoryImpl
import com.minseongkim.movie_sample.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    /**
     * Dependency Inject in [MovieRepository] Use Binds.
     */
    @Binds
    @Singleton
    abstract fun provideMovieRepository(repositoryImpl: MovieRepositoryImpl): MovieRepository
}