package com.home.weatherapp.localDatabase.roomDatabase.dao.sample

import androidx.room.*
import com.home.weatherapp.localDatabase.roomDatabase.model.sample_1.SampleTable1

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSample(appSettings: SampleTable1)



}
