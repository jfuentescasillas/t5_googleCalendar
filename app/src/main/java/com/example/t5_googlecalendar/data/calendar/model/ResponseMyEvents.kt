package com.example.t5_googlecalendar.data.calendar.model

import com.example.t5_googlecalendar.domain.model.EventDomainModel
import java.io.Serializable


data class ResponseMyEvents(
    val accessRole: String,
    val defaultReminders: List<Any>,
    val description: String,
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextSyncToken: String,
    val summary: String,
    val timeZone: String,
    val updated: String
)

data class Item(
    val created: String,
    val creator: Creator,
    val end: End,
    val etag: String,
    val eventType: String,
    val htmlLink: String,
    val iCalUID: String,
    val id: String,
    val kind: String,
    val location: String,
    val organizer: Organizer,
    val sequence: Int,
    val start: Start,
    val status: String,
    val summary: String,
    val updated: String
): Serializable

data class Creator(
    val email: String
)

data class End(
    val dateTime: String
)

data class Organizer(
    val displayName: String,
    val email: String,
    val self: Boolean
)

data class Start(
    val dateTime: String
)


fun Item.toDomainModel(): EventDomainModel {
    return EventDomainModel(summary?:"", start.dateTime, end.dateTime, id)
}