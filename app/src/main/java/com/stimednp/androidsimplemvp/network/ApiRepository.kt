package com.stimednp.androidsimplemvp.network

import com.stimednp.androidsimplemvp.data.EventItems
import com.stimednp.androidsimplemvp.data.EventResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rivaldy on 12/5/2019.
 */

interface ApiRepository {
    @GET("api/v1/json/1/eventspastleague.php")
    fun getPastMatch(@Query("id") id: String): Call<EventResponse>
}