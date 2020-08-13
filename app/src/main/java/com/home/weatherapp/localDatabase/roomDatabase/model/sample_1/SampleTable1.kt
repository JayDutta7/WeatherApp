package com.home.weatherapp.localDatabase.roomDatabase.model.sample_1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SampleTable1")
data class SampleTable1(
    @PrimaryKey/*(autoGenerate = true) */
    @ColumnInfo(name = "sampleText") val sampleText: String,
    @ColumnInfo(name = "sampleHeader") val sampleHeader: String?
)