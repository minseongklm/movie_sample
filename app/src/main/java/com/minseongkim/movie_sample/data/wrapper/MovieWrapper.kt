package com.minseongkim.movie_sample.data.wrapper

import com.minseongkim.movie_sample.data.model.*
import com.minseongkim.movie_sample.presentation.model.Actor
import com.minseongkim.movie_sample.presentation.model.Movie
import com.minseongkim.movie_sample.presentation.model.MovieDetail
import com.minseongkim.movie_sample.presentation.model.Movies

@JvmName("movieLocal")
fun List<MovieLocal>.wrapUiModel(): List<Movie> {
    return this.map { movieData ->
        Movie(
            id = movieData.id,
            posterImage = movieData.posterImg,
            section = movieData.section
        )
    }
}

@JvmName("movieRemote")
fun List<MovieRemote>.wrapUiModel(section: Section): List<Movie> {
    return this.map { movieData ->
        Movie(
            id = movieData.id,
            posterImage = movieData.posterImage,
            section = section.name
        )
    }
}

@JvmName("movieDetailLocal")
fun MovieDetailLocal.wrapUiModel(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        description = description,
        tagline = tagLine,
        genres = genres.wrapUiModel(),
        backgroundImage = backgroundImg,
    )
}

@JvmName("movieRemoteLocal")
fun MovieRemoteDetail.wrapUiModel(): MovieDetail {
    return MovieDetail(
        id = id,
        title = title,
        description = description,
        tagline = tagline,
        genres = genres.wrapUiModel(),
        backgroundImage = backgroundImage
    )
}

@JvmName("movieActorLocal")
fun List<ActorLocal>.wrapUiModel(): List<Actor> {
    return this.map { actorData ->
        Actor(
            movieId = actorData.movieId,
            name = actorData.name,
            character = actorData.characterName,
            profileImage = actorData.profileImg
        )
    }
}

@JvmName("movieActorRemote")
fun List<ActorRemote>.wrapUiModel(): List<Actor> {
    return this.map { actorData ->
        Actor(
            name = actorData.name,
            character = actorData.characterName,
            profileImage = actorData.profileImage
        )
    }
}

@JvmName("movieGenre")
fun List<Genre>.wrapUiModel(): List<String> {
    return this.map { it.name }
}


@JvmName("movieToMovies")
fun List<Movie>.wrapToMovies(section: Section): Movies {
    return Movies(section = section.name, movies = this)
}