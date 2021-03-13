package com.example.t5_googlecalendar.presentation.fragment.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.t5_googlecalendar.databinding.FragmentCalendarListBinding
import com.example.t5_googlecalendar.base.BaseExtraData
import com.example.t5_googlecalendar.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CalendarListFragment: BaseFragment<CalendarListState, CalendarListViewModel, FragmentCalendarListBinding>() {
    override val viewModelClass: Class<CalendarListViewModel> = CalendarListViewModel::class.java
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCalendarListBinding = FragmentCalendarListBinding::inflate
    lateinit var vm: CalendarListViewModel


    override fun setupView(viewModel: CalendarListViewModel) {
        vm = viewModel
    }


    override fun onNormal(data: CalendarListState) {
        data.calendar.let { calendar ->
            if (calendar != null) {
                binding.fragmentCalendarTitle.text = calendar.summary
            }

            if (calendar != null) {
                binding.fragmentCalendarDescription.text = calendar.description
            }
        }

        binding.cardView.setOnClickListener {
            //findNavController().navigate(CalendarFragmentDirections.actionCalendarFragmentToCalendarEventFragment(data.calendar!!.id))
        }
    }


    override fun onLoading(dataLoading: BaseExtraData?) {

    }

    override fun onError(dataError: Throwable) {

    }
}