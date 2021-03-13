package com.example.t5_googlecalendar.data.calendar.repository.network

import com.example.t5_googlecalendar.data.calendar.model.ResponseMyCalendar
import com.example.t5_googlecalendar.data.calendar.model.ResponseMyEvents
import retrofit2.http.GET


interface CalendarService {
    @GET("users/me/calendarList/v2aq7jave8rb3cqdmkj1hi8a3g@group.calendar.google.com")
    suspend fun getMyCalendar(): ResponseMyCalendar

    @GET("calendars/v2aq7jave8rb3cqdmkj1hi8a3g@group.calendar.google.com/events")
    suspend fun getMyEvents(): ResponseMyEvents
}