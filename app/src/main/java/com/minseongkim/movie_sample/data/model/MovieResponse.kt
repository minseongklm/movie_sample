package com.minseongkim.movie_sample.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * [MovieRemote] return movies list  data.
 *
 * used upcoming movies, recommend movies, popular movies and top rate movies.
 * @param id movie id
 * @param posterImage movies poster path
 */
@Serializable
data class MovieRemote(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "poster_path") val posterImage: String,
)

/**
 * [MovieRemoteDetail] is movie detail data.
 *
 * used get movie detail. not required interceptor.
 * @param title movie title
 * @param description movie description
 * @param tagline movie tag
 * @param genres movie genres
 * @param backgroundImage movie background image
 */
@Serializable
data class MovieRemoteDetail(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "title") val title: String,
    @SerialName(value = "overview") val description: String,
    @SerialName(value = "tagline") val tagline: String,
    @SerialName(value = "genres") val genres: List<Genre>,
    @SerialName(value = "backdrop_path") val backgroundImage: String,
)

/**
 * Actor on movie data.
 *
 * @param name actor's name.
 * @param characterName character's name in movie
 * @param profileImage actor profile image
 */
@Serializable
data class ActorRemote(
    @SerialName(value = "name") val name: String,
    @SerialName(value = "character") val characterName: String,
    @SerialName(value = "profile_path") val profileImage: String,
)

/**
 * Movie genre data.
 *
 * @param name genre name
 */
@Serializable
data class Genre(
    @SerialName(value = "name") val name: String
)