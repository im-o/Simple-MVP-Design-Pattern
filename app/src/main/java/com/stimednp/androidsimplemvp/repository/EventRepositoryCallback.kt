package com.stimednp.androidsimplemvp.repository

import com.stimednp.androidsimplemvp.data.EventItems

/**
 * Created by rivaldy on 12/5/2019.
 */

interface EventRepositoryCallback<T> {
//    fun onDataLoaded(data: T?)
    fun onDataLoad(data: ArrayList<EventItems>)
    fun odDataError()
}