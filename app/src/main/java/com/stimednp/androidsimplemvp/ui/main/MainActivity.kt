package com.stimednp.androidsimplemvp.ui.main

import android.os.Bundle
import android.util.Log.e
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.androidsimplemvp.R
import com.stimednp.androidsimplemvp.adapter.MainAdapter
import com.stimednp.androidsimplemvp.data.EventItems
import com.stimednp.androidsimplemvp.data.EventResponse
import com.stimednp.androidsimplemvp.repository.EventRepository
import kotlinx.android.synthetic.main.activity_main.*

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
        mainPresenter = MainPresenter(this, EventRepository())
        adapter = MainAdapter(events)
        rv_list_event.layoutManager = LinearLayoutManager(this)
        rv_list_event.adapter = adapter
    }

    private fun getEventLoaded() {
        val id = "4328"
        mainPresenter.getEvent(id)
    }

    override fun onShowLoading() {

    }

    override fun onHideLoading() {

    }

//    override fun onDataLoaded(data: EventResponse?) {
//        val items: ArrayList<EventItems> = arrayListOf()
//        for (i in data?.events?.indices!!) items.add(data.events[i])
//        events.clear()
//        events.addAll(items)
//        adapter.notifyDataSetChanged()
//    }

    override fun onDataLoad(data: ArrayList<EventItems>) {
        events.clear()
        events.addAll(data)
        adapter.notifyDataSetChanged()
        e("INIII","HASILL NYA : "+data)
    }

    override fun odDataError() {

    }
}
