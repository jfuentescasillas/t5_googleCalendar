package com.example.t5_googlecalendar.data.calendar.repository.local

import androidx.room.*
import com.example.t5_googlecalendar.data.calendar.model.EventEntityDataModel


// CRUD
@Dao
interface EventDAO {
    @Query("SELECT * FROM events")
    suspend fun getAll(): List<EventEntityDataModel>

    @Insert
    suspend fun insert(event: EventEntityDataModel)

    @Update
    suspend fun update(event: EventEntityDataModel)

    @Delete
    suspend fun delete(event: EventEntityDataModel)
}