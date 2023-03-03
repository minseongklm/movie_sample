package com.minseongkim.movie_sample.presentation.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minseongkim.movie_sample.R
import com.minseongkim.movie_sample.data.network.MovieApi
import com.minseongkim.movie_sample.presentation.viewmodel.MovieUiState


@BindingAdapter("app:mainImage")
fun AppCompatImageView.bindMainImage(uri: String) {
    uri.let {
        Glide.with(context)
            .load("${MovieApi.IMAGE_BASE_URL}${uri}")
            .into(this)
    }
}

@BindingAdapter("app:posterImage")
fun AppCompatImageView.bindPosterImage(uri: String) {
    val width = resources.getDimension(R.dimen.poster_default_width).toInt()
    val height = resources.getDimension(R.dimen.poster_default_height).toInt()
    uri.let {
        Glide.with(context)
            .load("${MovieApi.POSTER_BASE_URL}${uri}")
            .override(width, height)
            .into(this)
    }
}

@BindingAdapter("app:movieMainItems")
fun RecyclerView.bindMainItems(uiState: MovieUiState) {
    val bindAdapter = this.adapter
    if (bindAdapter is MovieHomeAdapter) {
        bindAdapter.submitList(uiState.movies)
    }
}

@BindingAdapter("app:optimized")
fun RecyclerView.optimized(check: Boolean = true) {
    if (check) {
        setHasFixedSize(true)
    }
}