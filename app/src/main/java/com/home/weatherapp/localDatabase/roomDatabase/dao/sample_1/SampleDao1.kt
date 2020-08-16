package com.home.weatherapp.localDatabase.roomDatabase.dao.sample_1

import androidx.room.*
import com.home.weatherapp.localDatabase.roomDatabase.model.sample.SampleTable

@Dao
interface SampleDao1 {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSample(sampleTable: SampleTable)


    @Update
    fun updateSample(sampleTable: SampleTable)
}