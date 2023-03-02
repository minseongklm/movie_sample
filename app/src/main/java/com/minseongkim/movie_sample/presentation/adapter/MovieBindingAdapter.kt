package com.minseongkim.movie_sample.presentation.adapter

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.minseongkim.movie_sample.data.network.MovieApi
import com.minseongkim.movie_sample.presentation.viewmodel.MovieUiState

@BindingAdapter("app:image")
fun AppCompatImageView.bindImage(uri: String) {
    uri.let {
        Glide.with(context)
            .load("${MovieApi.IMAGE_BASE_URL}/${uri}")
            .override(300, 350)
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