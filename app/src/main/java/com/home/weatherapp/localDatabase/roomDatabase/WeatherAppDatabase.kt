package com.home.weatherapp.localDatabase.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.home.weatherapp.localDatabase.roomDatabase.model.sample_1.SampleTable1
import com.home.weatherapp.localDatabase.roomDatabase.dao.sample.SampleDao

@Database(
    entities =
    [SampleTable1::class
     ], version = 1, exportSchema = false
)
abstract class WeatherAppDatabase : RoomDatabase() {

    /*Abstract class for getting the interface's*/
    abstract fun sampleList(): SampleDao



    //    Static
    companion object {

        private var INSTANCE: WeatherAppDatabase? = null

        fun getDatabase(context: Context): WeatherAppDatabase {

            if (INSTANCE == null) {

                /*
                 inMemoryDatabaseBuilder():
                 /////////////////////////////////////
                 The database will be created in system memory,
                  If you kill the app (Killing your process),
                   database will be removed and data will not be persisted.
                    This can be used while Testing.

                databaseBuilder() :
                 /////////////////////////////////////
                 The database will be created in /data/data/com.your.app and will be persisted.
                  This you will be using it in production.

                  */

                synchronized(WeatherAppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        WeatherAppDatabase::class.java,
                        "WeatherApp.db"
                    )     //.allowMainThreadQueries() //when publish no main thread call allowed
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE!!
        }

    }

}