package com.minseongkim.movie_sample.data.network

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONObject


enum class Key(value: String) {
    RESULT("results"), BACKDROP("backdrops"), CAST("cast");
}

/**
 * Interceptor for okHttp.
 */
class MovieInterceptor : Interceptor {

    /**
     * intercept request and manufacture json data.
     * @return Response
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request()) // get pure request.
        val responseJson = // wrap request to json.
            JSONObject(response.body?.string() ?: EMPTY_JSON)
        val resultPayload = when {
            responseJson.has(KEY_RESULT) -> responseJson[KEY_RESULT]
            responseJson.has(KEY_BACKDROP) -> responseJson[KEY_BACKDROP]
            responseJson.has(KEY_CAST) -> responseJson[KEY_CAST]
            else -> EMPTY_JSON
        }
        return response.newBuilder()
            .body(resultPayload.toString().toResponseBody())
            .build()
    }

    companion object {
        const val KEY_RESULT = "result"
        const val KEY_BACKDROP = "backdrops"
        const val KEY_CAST = "cast"
        const val EMPTY_JSON = "{}"
    }
}