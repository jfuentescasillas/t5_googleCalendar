package com.example.t5_googlecalendar.data.calendar.model

import com.example.t5_googlecalendar.domain.model.CalendarDomainModel
import java.io.Serializable


data class ResponseMyCalendar(
    val accessRole: String,
    val backgroundColor: String,
    val colorId: String,
    val conferenceProperties: ConferenceProperties,
    val defaultReminders: List<Any>,
    val description: String,
    val etag: String,
    val foregroundColor: String,
    val id: String,
    val kind: String,
    val selected: Boolean,
    val summary: String,
    val timeZone: String
): Serializable


data class ConferenceProperties(
    val allowedConferenceSolutionTypes: List<String>
)


fun ResponseMyCalendar.toDomainModel(): CalendarDomainModel {
    return CalendarDomainModel(summary, id, description)
}