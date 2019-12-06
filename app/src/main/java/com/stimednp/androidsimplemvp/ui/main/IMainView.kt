package com.stimednp.androidsimplemvp.ui.main

import com.stimednp.androidsimplemvp.data.EventItems
import com.stimednp.androidsimplemvp.data.EventResponse
import com.stimednp.androidsimplemvp.repository.EventRepositoryCallback

/**
 * Created by rivaldy on 12/5/2019.
 */

interface IMainView: EventRepositoryCallback<EventResponse> {
    fun onShowLoading()
    fun onHideLoading()
}