package com.example.t5_googlecalendar.presentation.fragment.form


import com.example.t5_googlecalendar.base.BaseViewModel
import com.example.t5_googlecalendar.domain.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CalendarEventViewModel @Inject constructor(private val repository: CalendarRepository): BaseViewModel<CalendarEventState>() {
    override val defaultState: CalendarEventState = CalendarEventState()


    override fun onStartFirstTime() { }


    fun requestInformation(calendarId: String) {
        updateToLoadingState()

        checkDataState { state ->
            executeCoroutines({
                val response = repository.getMyEvents()
                updateToNormalState(CalendarEventState(response))
            }, { error ->
                updateToErrorState(error)
            })
        }
    }
}