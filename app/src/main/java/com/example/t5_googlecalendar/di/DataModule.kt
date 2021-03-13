package com.example.t5_googlecalendar.di

import android.content.Context
import com.example.t5_googlecalendar.base.util.NetworkManager
import com.example.t5_googlecalendar.data.calendar.repository.CalendarRepositoryImpl
import com.example.t5_googlecalendar.data.calendar.repository.local.EventsLocal
import com.example.t5_googlecalendar.data.calendar.repository.network.CalendarNetwork
import com.example.t5_googlecalendar.data.calendar.repository.network.CalendarService
import com.example.t5_googlecalendar.data.config.CalendarRetrofit
import com.example.t5_googlecalendar.data.config.EventsDataBase
import com.example.t5_googlecalendar.domain.repository.CalendarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providesContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideCalendarRepository(retrofit: CalendarRetrofit, eventDataBase: EventsDataBase, networkManager: NetworkManager): CalendarRepository = CalendarRepositoryImpl(CalendarNetwork(retrofit.loadRetrofit().create(CalendarService::class.java)), EventsLocal(eventDataBase.loadDataBase().eventDao()))
}