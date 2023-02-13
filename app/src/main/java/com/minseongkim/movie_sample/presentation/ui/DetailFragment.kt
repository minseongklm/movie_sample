package com.minseongkim.movie_sample.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseongkim.movie_sample.R
import com.minseongkim.movie_sample.databinding.FragmentDetailBinding
import com.minseongkim.movie_sample.presentation.base.BaseFragment

/**
 * [DetailFragment] is screen for movie detail information.
 *
 * provide information to movie's detail and related movies.
 */
class DetailFragment : BaseFragment<FragmentDetailBinding>(R.layout.fragment_detail) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }
}