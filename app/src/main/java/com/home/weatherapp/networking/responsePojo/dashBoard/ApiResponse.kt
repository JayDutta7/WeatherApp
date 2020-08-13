package com.home.weatherapp.networking.responsePojo.dashBoard

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status")
    @Expose
    val status:Int,
    @SerializedName("msg")
    @Expose
    val msg:String,
    @SerializedName("result")
    @Expose
    val responseResult: ResponseResult?
)
