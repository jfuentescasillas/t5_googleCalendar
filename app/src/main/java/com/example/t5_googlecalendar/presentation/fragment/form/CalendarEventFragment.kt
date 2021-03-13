package com.example.t5_googlecalendar.presentation.fragment.form

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.t5_googlecalendar.base.BaseExtraData
import com.example.t5_googlecalendar.base.BaseFragment
import com.example.t5_googlecalendar.databinding.FragmentCalendarEventBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CalendarEventFragment: BaseFragment<CalendarEventState, CalendarEventViewModel, FragmentCalendarEventBinding>() {

    override val viewModelClass: Class<CalendarEventViewModel> = CalendarEventViewModel::class.java
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCalendarEventBinding = FragmentCalendarEventBinding::inflate
    private lateinit var vm: CalendarEventViewModel
    //private val args: CalendarEventFragmentArgs by navArgs<>()
    lateinit var mAdapter: CalendarEventAdapter

    override fun setupView(viewModel: CalendarEventViewModel) {
        vm = viewModel
        setupRecyclerView()
        setupButton()
        //vm.requestInformation(args.calendarId)
    }

    override fun onNormal(data: CalendarEventState) {
      //  binding.fragmentEventImageViewNoContent.visibility = if (data.eventList.isNotEmpty()) View.GONE else View.VISIBLE
        binding.fragmentListRecyclerview.visibility = if (data.eventList.isEmpty()) View.GONE else View.VISIBLE
        if (data.eventList.isNotEmpty()) {
            mAdapter.updateList(data.eventList)
        }
    }

    override fun onLoading(dataLoading: BaseExtraData?) {
    }

    override fun onError(dataError: Throwable) {
    }

    private fun setupButton() {
        /*binding.fragmentEventFloatButton.setOnClickListener {
            findNavController().navigate(CalendarEventFragmentDirections.actionCalendarEventFragmentToEventsFormFragment())
        }*/
    }

    private fun setupRecyclerView() {
        mAdapter = CalendarEventAdapter(listOf())
        binding.fragmentListRecyclerview.apply {
            adapter = mAdapter
            layoutManager = GridLayoutManager(requireActivity(), 1)
            itemAnimator = DefaultItemAnimator()
        }
    }

}