package com.stimednp.androidsimplemvp.ui.main

import com.stimednp.androidsimplemvp.data.EventItems
import com.stimednp.androidsimplemvp.data.EventResponse
import com.stimednp.androidsimplemvp.repository.EventRepository
import com.stimednp.androidsimplemvp.repository.EventRepositoryCallback

/**
 * Created by rivaldy on 12/5/2019.
 */

class MainPresenter(private val view: IMainView, private val eventRepository: EventRepository) {
    fun getEvent(id: String){
        view.onShowLoading()
        eventRepository.getEventPast(id, object : EventRepositoryCallback<EventResponse?>{
//            override fun onDataLoaded(data: EventResponse?) {
//                view.onDataLoaded(data)
//            }

            override fun odDataError() {
                view.odDataError()
            }

            override fun onDataLoad(data: ArrayList<EventItems>) {
                view.onDataLoad(data)
            }
        })
        view.onHideLoading()
    }
}