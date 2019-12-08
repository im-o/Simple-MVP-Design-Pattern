package com.stimednp.androidsimplemvp.ui.main

import com.stimednp.androidsimplemvp.base.IView
import com.stimednp.androidsimplemvp.model.EventResponse
import com.stimednp.androidsimplemvp.base.IPresenter

/**
 * Created by rivaldy on 12/5/2019.
 */

interface IMainView: IPresenter<EventResponse>, IView {
    fun onShowMessage(msg: String)
}