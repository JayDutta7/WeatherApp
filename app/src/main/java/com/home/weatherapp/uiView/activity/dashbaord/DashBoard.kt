package com.home.weatherapp.uiView.activity.dashbaord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.home.weatherapp.R
import com.home.weatherapp.uiView.BaseActivity

class DashBoard : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setContentView(): Int? {
        return R.layout.activity_dashboard
    }
}