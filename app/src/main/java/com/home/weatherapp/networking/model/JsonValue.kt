package com.home.weatherapp.networking.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class JsonValue(
    @SerializedName("question")
    @Expose
    var question: String
)