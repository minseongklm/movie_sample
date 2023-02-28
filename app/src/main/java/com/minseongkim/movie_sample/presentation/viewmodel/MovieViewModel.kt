package com.minseongkim.movie_sample.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.minseongkim.movie_sample.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * [MovieViewModel] holds information about movies.
 */
@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

}