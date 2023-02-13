package com.minseongkim.movie_sample.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseongkim.movie_sample.R
import com.minseongkim.movie_sample.databinding.FragmentSearchBinding
import com.minseongkim.movie_sample.presentation.base.BaseFragment

/**
 * [SearchFragment] is screen for search movies.
 *
 * provide movie detail information.
 */
class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }
}