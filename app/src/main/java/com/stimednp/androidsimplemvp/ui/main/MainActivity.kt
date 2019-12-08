package com.stimednp.androidsimplemvp.ui.main

import android.os.Bundle
import android.util.Log.e
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.androidsimplemvp.R
import com.stimednp.androidsimplemvp.adapter.MainAdapter
import com.stimednp.androidsimplemvp.model.EventItems
import com.stimednp.androidsimplemvp.presenter.RepositoryEvents
import com.stimednp.androidsimplemvp.utils.invisible
import com.stimednp.androidsimplemvp.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), IMainView {
    private lateinit var mainPresenter: MainPresenter
    private lateinit var adapter: MainAdapter
    var events =  ArrayList<EventItems>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initial()
        getEventLoaded()
    }

    private fun initial() {
        mainPresenter = MainPresenter(this, RepositoryEvents())
        adapter = MainAdapter(events)
        rv_list_event.layoutManager = LinearLayoutManager(this)
        rv_list_event.adapter = adapter
    }

    private fun getEventLoaded() {
        val id = "4328"
        mainPresenter.getEvent(id)
    }

    override fun onDataLoaded(data: ArrayList<EventItems>) {
        onHideLoading()
        onShowMessage("sukses load data")
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
    }

    override fun onDataError() {
        onHideLoading()
        onShowMessage("Gagal load data")
        e("INIII","onDataError")
    }

    override fun onShowLoading() {
        progrress_main.visible()
        e("INIII","onShowLoading")
    }

    override fun onHideLoading() {
        progrress_main.invisible()
        e("INIII","onHideLoading")
    }

    override fun onShowMessage(msg: String) {
        toast(msg)
        e("INIII","onShowMessage")
    }
}
