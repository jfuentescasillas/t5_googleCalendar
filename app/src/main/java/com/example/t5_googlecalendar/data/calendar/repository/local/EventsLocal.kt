package com.example.t5_googlecalendar.data.calendar.repository.local

import com.example.t5_googlecalendar.data.calendar.model.EventEntityDataModel
import javax.inject.Inject


// CRUD Local
class EventsLocal @Inject constructor(private val dao: EventDAO) {
    suspend fun getAll(): List<EventEntityDataModel>{
        return dao.getAll()
    }


    suspend fun insert(event: EventEntityDataModel){
        dao.insert(event)
    }


    suspend fun update(event: EventEntityDataModel){
        dao.update(event)
    }


    suspend fun delete(event: EventEntityDataModel){
        dao.delete(event)
    }
}