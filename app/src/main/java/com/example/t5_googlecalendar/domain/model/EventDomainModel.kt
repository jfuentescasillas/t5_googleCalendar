package com.example.t5_googlecalendar.domain.model


// Keep simple names
data class EventDomainModel(
    val id: String = "",
    val summary: String = "",
    val start: String = "",
    val end: String = ""
)
