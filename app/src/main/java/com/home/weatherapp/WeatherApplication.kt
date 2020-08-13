package com.home.weatherapp

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex
import com.home.weatherapp.localDatabase.roomDatabase.WeatherAppDatabase
import com.home.weatherapp.localDatabase.roomDatabase.WeatherAppDatabase.Companion.getDatabase
import com.home.weatherapp.localDatabase.sharedPreference.SharedPreferenceImpl
import com.home.weatherapp.utility.ReleaseApkTreeLog
import timber.log.Timber

class WeatherApplication: Application(), Application.ActivityLifecycleCallbacks  {
    override fun onActivityPaused(activity: Activity) {
        Timber.e("onActivityPaused--${activity.componentName.className}")
    }

    override fun onActivityStarted(activity: Activity) {
        Timber.e("onActivityStarted--${activity.componentName.className}")
    }

    override fun onActivityDestroyed(activity: Activity) {
        Timber.e("onActivityDestroyed--${activity.componentName.className}")
        //if (activity is BaseActivity) {
        isInterestingActivityVisible = false
        // }
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
        Timber.e("""onActivitySaveInstanceState--${activity.componentName.className}""")
    }

    override fun onActivityStopped(activity: Activity) {
        Timber.e("onActivityStopped--${activity.componentName.className}")
        //if (activity is BaseActivity) {
        isInterestingActivityVisible = false
        //}
    }

    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        Timber.e("onActivityCreated--${activity.componentName.className}")
    }

    override fun onActivityResumed(activity: Activity) {
        Timber.e("onActivityResumed--${activity.componentName.className}")
        //if (activity is BaseActivity) {
            isInterestingActivityVisible = true
        //}
    }

    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        /**initialize multiDex for over 65k methods in application class*/
        MultiDex.install(context)
    }

    /**
     * checking internet connection*/
    private var isInterestingActivityVisible = false
    /**
     * SharedPreference*/
    private lateinit var sharedPreference: SharedPreferenceImpl

    /**
     * Room Database*/
    private lateinit var weatherDatabase: WeatherAppDatabase

    /**Init blocks execute after primary constructor*/
    init {
        instance = this
    }

    /**
     * Static Field*/
    companion object {
        private lateinit var instance: WeatherApplication

        /**
         * getting context from application class*/
        fun getApplicationContext(): Context {
            //Timber.e("Context--ApplicationContext")
            return instance.applicationContext
        }

        /**
         * getting  SharedPref through application class*/
        fun getPref(): SharedPreferenceImpl {
            //Timber.e( "LocalDatabase--SharedPref")
            return instance.sharedPreference
        }

        /**
         *getting RoomDatabase through application class*/
        fun getRoomDatabase(): WeatherAppDatabase {
            //Timber.e( "Room--LocalDatabase")
            return instance.weatherDatabase
        }

    }

    override fun onCreate() {
        super.onCreate()
        //Register Activity Callbacks
        registerActivityLifecycleCallbacks(this)

        /**Initialize Timber-Log as Per Build Wise**/
        when {
            BuildConfig.DEBUG -> {
                Timber.plant(Timber.DebugTree())
            }
            else -> {
                Timber.plant(ReleaseApkTreeLog())
            }
        }

        /**initialize Room-DB in the application class*/
        weatherDatabase = getDatabase(context = applicationContext)

        /**initialize SharedPreference in application class*/
        sharedPreference = SharedPreferenceImpl(context = applicationContext)

    }

}