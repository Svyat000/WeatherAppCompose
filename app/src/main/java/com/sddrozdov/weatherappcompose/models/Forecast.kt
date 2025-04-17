package com.sddrozdov.weatherappcompose.models

import com.google.gson.annotations.SerializedName

data class Forecast(
    @SerializedName("forecastday") val forecastDays: List<ForecastDay>
)
data class ForecastDay(
    val date: String,
    val day: Day,
    val hour: List<Hour>
)
data class Day(
    @SerializedName("maxtemp_c") val maxTempC: Double,
    @SerializedName("mintemp_c") val minTempC: Double,
    val condition: Condition,
)

