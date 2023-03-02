package com.minseongkim.movie_sample.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Model class for movie.
 * this model is complex movie data from remote.
 *
 * @param id id of the movie. from remote movie list
 * @param title title of the movie. from movie detail
 * @param description description of movie. from movie detail
 * @param tagLine tagline of movie. from movie detail
 * @param genres genre list of movie. from movie detail
 * @param backgroundImg background image path of the movie. from movie detail
 * @param posterImg poster image path of the movie. from remote movie list
 * @param section [Section]
 */
@Entity(tableName = "movies")
data class MovieLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "posterImage") val posterImg: String = "",
    @ColumnInfo(name = "section") val section: String = Section.UPCOMING.name
)


@Entity(tableName = "movie_detail")
data class MovieDetailLocal(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "description") val description: String = "",
    @ColumnInfo(name = "tagline") val tagLine: String = "",
    @ColumnInfo(name = "genres") val genres: List<Genre> = listOf(),
    @ColumnInfo(name = "backgroundImage") val backgroundImg: String = "",
)

/**
 * Actor class for movie.
 *
 * @param movieId movie id
 * @param name actor name
 * @param characterName actor's character name on movie
 * @param profileImg actor profile image path
 */
@Entity(tableName = "actors")
data class ActorLocal(
    @PrimaryKey @ColumnInfo(name = "movieId") val movieId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "character") val characterName: String,
    @ColumnInfo(name = "profileImage") val profileImg: String,
)

/**
 * [Section] divides where the movie data came from.
 */
enum class Section {
    UPCOMING, POPULAR, TOPRATE;
}