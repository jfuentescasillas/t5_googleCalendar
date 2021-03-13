package com.example.t5_googlecalendar.presentation.fragment.form

import com.example.t5_googlecalendar.base.BaseViewState
import com.example.t5_googlecalendar.data.calendar.model.ResponseMyCalendar


data class CalendarFormState(
    val calendar: ResponseMyCalendar? = null
): BaseViewState()

