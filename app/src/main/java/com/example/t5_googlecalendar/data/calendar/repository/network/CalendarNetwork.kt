package com.example.t5_googlecalendar.data.calendar.repository.network

import com.example.t5_googlecalendar.data.calendar.model.ResponseMyCalendar
import com.example.t5_googlecalendar.data.calendar.model.ResponseMyEvents
import javax.inject.Inject


class CalendarNetwork @Inject constructor(private val service: CalendarService) {
    suspend fun getMyCalendar(): ResponseMyCalendar {
        return service.getMyCalendar()
    }


    suspend fun getMyEvents(): ResponseMyEvents {
        return service.getMyEvents()
    }
}