package com.home.weatherapp.networking.responsePojo.dashBoard

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseResult(
    @SerializedName("answer")
    @Expose
    val answer: String?
)