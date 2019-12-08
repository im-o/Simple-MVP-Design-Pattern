package com.stimednp.androidsimplemvp.presenter

import com.stimednp.androidsimplemvp.base.IPresenter
import com.stimednp.androidsimplemvp.model.EventResponse
import com.stimednp.androidsimplemvp.network.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * Created by rivaldy on 12/5/2019.
 */

class RepositoryEvents {
    fun getEventPast(id: String, callback: IPresenter<EventResponse?>) {
        val tsdbRepo = ApiClient.iRepository
        //Use Coroutines
        GlobalScope.launch(Dispatchers.Main){
            val listEvent = tsdbRepo.getPastMatch(id)
            try {
                val response = listEvent.await()
                if (response.isSuccessful){
                    val resbody = response.body()
                    callback.onDataLoaded(resbody?.events!!)
                } else{
                    callback.onDataError()
                }
            }catch (er: Exception){
                callback.onDataError()
            }
            //Before Use Coroutines
//            tsdbRepo.getPastMatch(id)
//                .enqueue(object : Callback<EventResponse?> {
//                    override fun onFailure(call: Call<EventResponse?>, t: Throwable) {
//                        callback.onDataError()
//                    }
//
//                    override fun onResponse(call: Call<EventResponse?>,response: Response<EventResponse?>) {
//                        response.let {
//                            if (it.isSuccessful){
//                                val body: ArrayList<EventItems>? = it.body()?.events
//                                val list = ArrayList<EventItems>()
//                                for (i in body?.indices!!){
//                                    list.add(body[i])
//                                }
////                            callback.onDataLoadeded(it.body())
//                                callback.onDataLoaded(list)
//                            }else{
//                                callback.onDataError()
//                            }
//                        }
//                    }
//
//                })

        }
    }
}