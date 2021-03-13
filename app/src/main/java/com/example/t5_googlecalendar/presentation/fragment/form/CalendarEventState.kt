package com.example.t5_googlecalendar.presentation.fragment.form

import com.example.t5_googlecalendar.base.BaseViewState
import com.example.t5_googlecalendar.domain.model.EventDomainModel


data class CalendarEventState(
    val eventList: List<EventDomainModel> = listOf()
) : BaseViewState()