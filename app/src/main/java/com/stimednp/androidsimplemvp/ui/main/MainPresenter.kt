package com.stimednp.androidsimplemvp.ui.main

import com.stimednp.androidsimplemvp.base.IPresenter
import com.stimednp.androidsimplemvp.model.EventItems
import com.stimednp.androidsimplemvp.model.EventResponse
import com.stimednp.androidsimplemvp.presenter.RepositoryEvents

/**
 * Created by rivaldy on 12/5/2019.
 */

class MainPresenter(private val view: IMainView, private val repositoryEvents: RepositoryEvents) : IMainPresenter {
    override fun getEvent(id: String) {
        repositoryEvents.getEventPast(id, object : IPresenter<EventResponse?> {
            override fun onDataError() {
                view.onDataError()
            }

            override fun onDataLoaded(data: ArrayList<EventItems>) {
                view.onDataLoaded(data)
            }
        })
    }
}