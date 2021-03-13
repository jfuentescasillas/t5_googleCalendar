package com.example.t5_googlecalendar.presentation.fragment.list

import com.example.t5_googlecalendar.base.BaseViewState
import com.example.t5_googlecalendar.data.calendar.model.ResponseMyCalendar


data class CalendarListState(
    val calendar: ResponseMyCalendar? = null
): BaseViewState()

