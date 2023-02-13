package com.minseongkim.movie_sample.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minseongkim.movie_sample.R
import com.minseongkim.movie_sample.databinding.FragmentLikeBinding
import com.minseongkim.movie_sample.presentation.base.BaseFragment

/**
 * [LikeFragment] is screen for like movies.
 */
class LikeFragment : BaseFragment<FragmentLikeBinding>(R.layout.fragment_like) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        return view
    }
}