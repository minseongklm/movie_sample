package com.minseongkim.movie_sample.presentation.di

import android.content.Context
import androidx.room.Room
import com.minseongkim.movie_sample.data.local.ActorDao
import com.minseongkim.movie_sample.data.local.AppDatabase
import com.minseongkim.movie_sample.data.local.LocalDatasource
import com.minseongkim.movie_sample.data.local.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    /**
     * Set Room database.
     */
    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "Movies.db")
            .build()
    }

    /**
     * Set Dao.
     */
    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): MovieDao {
        return appDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideActorDao(appDatabase: AppDatabase): ActorDao {
        return appDatabase.actorDao()
    }

    /**
     * Inject Dependency in local datasource.
     */
    @Singleton
    @Provides
    fun provideLocalDatasource(
        movieDao: MovieDao,
        actorDao: ActorDao,
    ): LocalDatasource {
        return LocalDatasource(movieDao, actorDao)
    }
}