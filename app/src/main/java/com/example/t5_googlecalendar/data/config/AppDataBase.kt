package com.example.t5_googlecalendar.data.config

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.t5_googlecalendar.data.calendar.model.EventEntityDataModel
import com.example.t5_googlecalendar.data.calendar.repository.local.EventDAO


@Database(entities = [EventEntityDataModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun eventDao(): EventDAO
}