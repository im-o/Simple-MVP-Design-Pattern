package com.stimednp.androidsimplemvp.repository

import com.stimednp.androidsimplemvp.data.EventItems
import com.stimednp.androidsimplemvp.data.EventResponse
import com.stimednp.androidsimplemvp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by rivaldy on 12/5/2019.
 */

class EventRepository {
    fun getEventPast(id: String, callback: EventRepositoryCallback<EventResponse?>) {
        val tsdbRepo = ApiClient.iRepository
        tsdbRepo.getPastMatch(id)
            .enqueue(object : Callback<EventResponse?> {
                override fun onFailure(call: Call<EventResponse?>, t: Throwable) {
                    callback.odDataError()
                }

                override fun onResponse(call: Call<EventResponse?>,response: Response<EventResponse?>) {
                    response.let {
                        if (it.isSuccessful){
                            val body: ArrayList<EventItems>? = it.body()?.events
                            val list = ArrayList<EventItems>()
                            for (i in body?.indices!!){
                                list.add(body[i])
                            }
//                            callback.onDataLoaded(it.body())
                            callback.onDataLoad(list)
                        }else{
                            callback.odDataError()
                        }
                    }
                }

            })
    }
}