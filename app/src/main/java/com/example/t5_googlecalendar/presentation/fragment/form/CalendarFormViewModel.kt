package com.example.t5_googlecalendar.presentation.fragment.form

import com.example.t5_googlecalendar.base.BaseViewModel
import com.example.t5_googlecalendar.domain.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CalendarFormViewModel @Inject constructor(private val repository: CalendarRepository): BaseViewModel<CalendarFormState>() {
    override val defaultState: CalendarFormState = CalendarFormState()


    override fun onStartFirstTime() {
        requestInformation()
    }


    private fun requestInformation(){
        updateToLoadingState()

        checkDataState { state ->
            executeCoroutines({
                val response = repository.getMyCalendar()
                updateToNormalState(state.copy(calendar = response))
            }, { error ->
                updateToErrorState(error)
            })
        }
    }
}