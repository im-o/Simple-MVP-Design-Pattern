package com.stimednp.androidsimplemvp.adapter

import android.util.Log.e
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stimednp.androidsimplemvp.R
import com.stimednp.androidsimplemvp.data.EventItems
import kotlinx.android.synthetic.main.item_list_event.view.*

/**
 * Created by rivaldy on 12/6/2019.
 */

class MainAdapter(private val listItem: ArrayList<EventItems>) : RecyclerView.Adapter<MainAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_event, parent, false))
    }

    override fun getItemCount() = listItem.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bindItem(listItem[position])
    }

    class EventViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(events: EventItems){
            view.tv_idevent.text = events.idEvent
            view.tv_strevent.text = events.strEvent
        }
    }
}