package com.home.weatherapp.localDatabase.roomDatabase.model.sample

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "appSpecification")
data class SampleTable(
    @PrimaryKey
    @ColumnInfo(name = "appType") val appType: Int,
    @ColumnInfo(name = "appApiEncryption") val appApiEncryption: Boolean
)