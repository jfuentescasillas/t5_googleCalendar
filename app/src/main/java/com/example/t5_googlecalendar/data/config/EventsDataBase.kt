package com.example.t5_googlecalendar.data.config

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class EventsDataBase @Inject constructor(@ApplicationContext private val context: Context) {
    fun loadDataBase(): AppDataBase {
        return Room.databaseBuilder(context, AppDataBase::class.java, "events.db").build()
    }
}