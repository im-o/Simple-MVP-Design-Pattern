package com.stimednp.androidsimplemvp.network

import com.stimednp.androidsimplemvp.model.EventResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rivaldy on 12/5/2019.
 */

interface ApiRepository {
    @GET("api/v1/json/1/eventspastleague.php")
    fun getPastMatch(@Query("id") id: String): Deferred<Response<EventResponse>>
}