package com.minseongkim.movie_sample.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.minseongkim.movie_sample.R
import com.minseongkim.movie_sample.databinding.FragmentHomeBinding
import com.minseongkim.movie_sample.presentation.base.BaseFragment
import com.minseongkim.movie_sample.presentation.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * [HomeFragment] is First screen of movies app.
 *
 * Show movies by several genres and provide navigate other fragment.
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val movieViewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            movieViewModel.uiState.collect {
                Log.d("TAG", "onCreateView: $it")
            }
        }
        bind {
            viewModel = movieViewModel
        }
        return view
    }
}