package com.minseongkim.movie_sample.data.model

import kotlinx.serialization.Serializable

/**
 * Use KotlinX Serializable.
 *
 * [MovieModel] is model for only data layer.
 */
@Serializable
data class MovieModel(
    val id: Int,
)
