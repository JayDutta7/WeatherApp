package com.home.weatherapp.localDatabase.roomDatabase.dao.sample

import androidx.room.*
import com.home.weatherapp.localDatabase.roomDatabase.model.sample_1.SampleTable1
import io.reactivex.Single

@Dao
interface SampleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSample(appSettings: SampleTable1)

    @Query("SELECT * FROM SampleTable1")
    fun getSample(): Single<SampleTable1>


}
