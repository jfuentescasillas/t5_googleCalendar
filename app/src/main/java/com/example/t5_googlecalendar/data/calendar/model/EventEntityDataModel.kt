package com.example.t5_googlecalendar.data.calendar.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.t5_googlecalendar.domain.model.EventDomainModel


@Entity(tableName = "events")
data class EventEntityDataModel(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "summary") val title: String,
    @ColumnInfo(name = "start") val start: String,
    @ColumnInfo(name = "end") val end: String
)


fun EventEntityDataModel.toDomainModel(): EventDomainModel {
    return EventDomainModel(uid, title, start, end)
}


fun EventDomainModel.toDataModel(): EventEntityDataModel {
    return EventEntityDataModel(id, title, start, end)
}