package com.minseongkim.movie_sample.data.wrapper

import com.minseongkim.movie_sample.data.model.*
import com.minseongkim.movie_sample.presentation.model.*

@JvmName("movieLocal")
fun List<MovieLocal>.wrapUiModel(
    layoutType: LayoutStyle = LayoutStyle.NORMAL
): List<Movie> {
    return this.map { movieData ->
        Movie(
            id = movieData.id,
            posterImage = movieData.posterImg,
            section = movieData.section,
            layoutType = layoutType
        )
    }
}

@JvmName("movieRemote")
fun List<MovieRemote>.wrapUiModel(
    section: Section,
    layoutType: LayoutStyle = LayoutStyle.NORMAL
): List<Movie> {
    return this.map { movieData ->
        Movie(
            id = movieData.id,
            posterImage = movieData.posterImage,
            section = section.name,
            layoutType = layoutType
        )
    }
}

@JvmName("remoteToLocal")
fun List<MovieRemote>.wrapLocalModel(
    section: Section
): List<MovieLocal> {
    return this.map { movieRemote ->
        MovieLocal(
            id = movieRemote.id,
            posterImg = movieRemote.posterImage,
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