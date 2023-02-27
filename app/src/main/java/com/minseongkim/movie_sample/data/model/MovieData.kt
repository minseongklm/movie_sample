package com.minseongkim.movie_sample.data.model

import kotlinx.serialization.Serializable

@Serializable
data class MovieData(
    val id: Int,
)

data class MovieRequest(
    val page: Int,
    val results: List<MovieData>,
)
