package com.minseongkim.movie_sample.data.network

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import org.json.JSONObject

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
        val responseJson = JSONObject(response.body?.string() ?: "") // wrap request to json.
        // TODO if payload has not data, throw exception.
        val resultPayload = if (responseJson.has(KEY_RESULT)) responseJson[KEY_RESULT] else ""
        return response.newBuilder()
            .body(resultPayload.toString().toResponseBody())
            .build()
    }

    companion object {
        const val KEY_RESULT = "results"
    }
}