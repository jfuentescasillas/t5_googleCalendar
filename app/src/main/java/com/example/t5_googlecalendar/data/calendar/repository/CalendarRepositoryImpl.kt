package com.example.t5_googlecalendar.data.calendar.repository


import com.example.t5_googlecalendar.data.calendar.model.Item
import com.example.t5_googlecalendar.data.calendar.model.ResponseMyCalendar
import com.example.t5_googlecalendar.data.calendar.model.toDataModel
import com.example.t5_googlecalendar.data.calendar.repository.local.EventsLocal
import com.example.t5_googlecalendar.data.calendar.repository.network.CalendarNetwork
import com.example.t5_googlecalendar.domain.model.EventDomainModel
import com.example.t5_googlecalendar.domain.repository.CalendarRepository
import com.example.t5_googlecalendar.data.calendar.model.toDomainModel
import com.example.t5_googlecalendar.domain.model.CalendarDomainModel
import javax.inject.Inject


class CalendarRepositoryImpl @Inject constructor(private val network: CalendarNetwork, private val local: EventsLocal): CalendarRepository {
    //Network
    override suspend fun getMyCalendar(): CalendarDomainModel{
        return network.getMyCalendar().toDomainModel()
    }


    override suspend fun getMyEvents(): List<EventDomainModel> {
        return network.getMyEvents().items.map { it.toDomainModel() }
    }


    //Local
    override suspend fun getAll(): List<EventDomainModel> {
        return local.getAll().map { it.toDomainModel() }
    }


    override suspend fun deleteAl(event: EventDomainModel) {
    }


    override suspend fun insert(event: EventDomainModel) {
        local.insert(event.toDataModel())
    }


    override suspend fun update(event: EventDomainModel) {
        local.update(event.toDataModel())
    }


    override suspend fun delete(event: EventDomainModel) {
        local.delete(event.toDataModel())
    }
}