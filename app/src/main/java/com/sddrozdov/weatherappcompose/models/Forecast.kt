package com.sddrozdov.weatherappcompose.models

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>
)
