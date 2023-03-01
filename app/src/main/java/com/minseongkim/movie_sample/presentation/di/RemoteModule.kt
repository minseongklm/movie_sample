package com.minseongkim.movie_sample.presentation.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.minseongkim.movie_sample.data.network.MovieApi
import com.minseongkim.movie_sample.data.network.MovieInterceptor
import com.minseongkim.movie_sample.data.network.MovieService
import com.minseongkim.movie_sample.data.network.RemoteDatasource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    /**
     * Set Interceptor on retrofit for modify Json data.
     */
    @Provides
    @Singleton
    fun provideMovieInterceptor(): MovieInterceptor {
        return MovieInterceptor()
    }

    /**
     * Set OkHttp client.
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: MovieInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

    /**
     * Set Retrofit client with okhttp and Kotlinx Serializable.
     */
    @Provides
    @Singleton
    @OptIn(ExperimentalSerializationApi::class)
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        // kotlinx type converter.
        val contentType = "application/json".toMediaType()
        // this Json set for not required data.
        val format = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(MovieApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(format.asConverterFactory(contentType))
            .build()
    }

    /**
     * Create Retrofit.
     */
    @Provides
    @Singleton
    fun provideMovieService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }

    /**
     * Inject Dependency in remote datasource.
     */
    @Provides
    @Singleton
    fun provideRemoteDatasource(service: MovieService): RemoteDatasource {
        return RemoteDatasource(service)
    }
}