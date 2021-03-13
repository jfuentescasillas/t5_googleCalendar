package com.example.t5_googlecalendar.presentation.fragment.list

import com.example.t5_googlecalendar.domain.repository.CalendarListRepository
import com.example.t5_googlecalendar.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CalendarListViewModel @Inject constructor(private val repository: CalendarListRepository): BaseViewModel<CalendarListState>() {
    override val defaultState: CalendarListState = CalendarListState()


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