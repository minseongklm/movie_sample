package com.minseongkim.movie_sample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.minseongkim.movie_sample.data.MovieRepository
import com.minseongkim.movie_sample.presentation.model.Movie
import com.minseongkim.movie_sample.presentation.util.Async
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject


data class MovieUiState(
    val movies: List<Movie> = emptyList(),
    val isLoading: Boolean = false,
    val message: Int? = null
)

/**
 * [MovieViewModel] holds information about movies.
 */
@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _message: MutableStateFlow<Int?> = MutableStateFlow(null)
    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val _moviesAsync =
        combine(upcomingMovie(), popularMovie(), topRatingMovie()) { c, p, r -> c + p + r }
            .map { Async.Success(it) }
            .catch<Async<List<Movie>>> { emit(Async.Error(1)) }

    val uiState: StateFlow<MovieUiState> = combine(
        _isLoading, _message, _moviesAsync
    ) { loading, message, movies ->
        when (movies) {
            Async.Loading -> {
                MovieUiState(isLoading = true)
            }
            is Async.Error -> {
                MovieUiState(message = movies.errorMessage)
            }
            is Async.Success -> {
                MovieUiState(
                    movies = movies.data,
                    isLoading = loading,
                    message = message
                )
            }
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = MovieUiState(isLoading = true)
    )

    private fun upcomingMovie(): Flow<List<Movie>> {
        return repository.getMoviesByComing()
    }

    private fun popularMovie(): Flow<List<Movie>> {
        return repository.getMoviesByPopular()
    }

    private fun topRatingMovie(): Flow<List<Movie>> {
        return repository.getMoviesByRate()
    }
}