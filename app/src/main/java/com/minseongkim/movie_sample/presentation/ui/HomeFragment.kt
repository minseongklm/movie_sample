package com.minseongkim.movie_sample.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseongkim.movie_sample.R
import com.minseongkim.movie_sample.databinding.FragmentHomeBinding
import com.minseongkim.movie_sample.presentation.base.BaseFragment

/**
 * [HomeFragment] is First screen of movies app.
 *
 * Show movies by several genres and provide navigate other fragment.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }
}