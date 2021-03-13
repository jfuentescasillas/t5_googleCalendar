package com.example.t5_googlecalendar.presentation.fragment.form

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t5_googlecalendar.base.util.toMyDateFormat
import com.example.t5_googlecalendar.databinding.ItemCalendarEventListBinding
import com.example.t5_googlecalendar.domain.model.EventDomainModel


class CalendarEventAdapter(private var dataSet: List<EventDomainModel>) : RecyclerView.Adapter<CalendarEventAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemCalendarEventListBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCalendarEventListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false))
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]

        viewHolder.binding.apply {
            itemCalendarEventTitle.text = item.summary
            itemCalendarEventStart.text = item.start.toMyDateFormat()
            itemCalendarEventEnd.text = item.end.toMyDateFormat()
        }
    }


    override fun getItemCount() = dataSet.size


    fun updateList(newList: List<EventDomainModel>){
        dataSet = newList
        notifyDataSetChanged()
    }
}