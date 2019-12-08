package com.stimednp.androidsimplemvp.base

import com.stimednp.androidsimplemvp.model.EventItems

/**
 * Created by rivaldy on 12/5/2019.
 */

interface IPresenter<T> {
    fun onDataLoaded(data: ArrayList<EventItems>)
    fun onDataError()
}