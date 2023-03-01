package com.minseongkim.movie_sample.presentation.model

import com.minseongkim.movie_sample.data.model.Section

/**
 * Complex model for presentation layer.
 */
data class Movie(
    val id: Int = 0,
    val posterImage: String = "",
    val section: String = Section.UPCOMING.name,
)

data class MovieDetail(
    val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val tagline: String = "",
    val genres: List<String> = listOf(),
    val backgroundImage: String = "",
    val actor: List<Actor> = listOf()
)

/**
 * Actor model for presentation layer.
 */
data class Actor(
    val movieId: Int = 0,
    val name: String = "",
    val character: String = "",
    val profileImage: String = ""
)