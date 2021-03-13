package com.example.t5_googlecalendar.domain.repository

import com.example.t5_googlecalendar.domain.model.CalendarDomainModel
import com.example.t5_googlecalendar.domain.model.EventDomainModel


interface CalendarRepository {
    // Network connectivity
    suspend fun getMyCalendar(): CalendarDomainModel
    suspend fun getMyEvents(): List<EventDomainModel>

    // Local only
    suspend fun getAll(): List<EventDomainModel>
    suspend fun deleteAl(event: EventDomainModel)
    suspend fun insert(event: EventDomainModel)
    suspend fun update(event: EventDomainModel)
    suspend fun delete(event: EventDomainModel)
}