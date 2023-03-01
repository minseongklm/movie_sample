package com.minseongkim.movie_sample.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.minseongkim.movie_sample.data.model.ActorRemote
import com.minseongkim.movie_sample.data.model.Genre
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class GenreTypeConverter {
    @TypeConverter
    fun genresToJson(value: List<Genre>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun jsonToGenres(value: String): List<Genre> {
        return Json.decodeFromString(value)
    }
}

@ProvidedTypeConverter
class ActorTypeConverter {
    @TypeConverter
    fun actorsToJson(value: List<ActorRemote>): String {
        return Json.encodeToString(value)
    }

    @TypeConverter
    fun jsonToActor(value: String): List<ActorRemote> {
        return Json.decodeFromString(value)
    }
}