package com.minseongkim.movie_sample.presentation.model

import com.minseongkim.movie_sample.data.model.Section

data class Movies(
    val section: String = Section.UPCOMING.name,
    val layoutType: LayoutStyle = LayoutStyle.NORMAL,
    val movies: List<Movie> = emptyList(),
)

/**
 * Complex model for presentation layer.
 */
data class Movie(
    val id: Int = 0,
    val posterImage: String = "",
    val section: String = Section.UPCOMING.name,
)

/**
 * movie detail for presentation layer.
 */
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

enum class LayoutStyle {
    TOP, NORMAL;
}

//{
//    "backdrop_path": "/yiNSuWLgdPNao5nnR5RvTIX1jWf.jpg",
//    "id": 617882,
//    "original_language": "ko",
//    "original_title": "소울메이트",
//    "overview": "A movie about two friends who first met at the age of 13, looking back on the nature of their relationship through 14 years of meeting and separation, friendship and love, yearning and jealousy.",
//    "poster_path": "/vSdzWYiU5EmxxsQPUmBg6i20Xcd.jpg",
//    "release_date": "2023-03-15",
//    "title": "Soulmate",
//    "video": false,
//    "vote_average": 0,
//    "vote_count": 0
//},