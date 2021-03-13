package com.example.t5_googlecalendar.domain.repository

import com.example.t5_googlecalendar.domain.model.EventDomainModel

// Not really needed, but I'll keep it here just if necessary
interface EventsRepository  {
    suspend fun getAll(): List<EventDomainModel>
    suspend fun insert(event: EventDomainModel)
    suspend fun update(event: EventDomainModel)
    suspend fun delete(event: EventDomainModel)
}