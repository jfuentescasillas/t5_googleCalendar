package com.example.t5_googlecalendar.presentation.fragment.form

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.t5_googlecalendar.databinding.FragmentCalendarFormBinding
import com.example.t5_googlecalendar.base.BaseExtraData
import com.example.t5_googlecalendar.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CalendarFormFragment: BaseFragment<CalendarFormState, CalendarFormViewModel, FragmentCalendarFormBinding>() {
    override val viewModelClass: Class<CalendarFormViewModel> = CalendarFormViewModel::class.java
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCalendarFormBinding = FragmentCalendarFormBinding::inflate
    lateinit var vm: CalendarFormViewModel


    override fun setupView(viewModel: CalendarFormViewModel) {
        vm = viewModel
    }


    override fun onNormal(data: CalendarFormState) {

    }


    override fun onLoading(dataLoading: BaseExtraData?) {

    }

    override fun onError(dataError: Throwable) {

    }
}