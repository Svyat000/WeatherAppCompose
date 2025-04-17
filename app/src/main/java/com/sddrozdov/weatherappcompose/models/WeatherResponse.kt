package com.sddrozdov.weatherappcompose.models

data class WeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: Forecast
)