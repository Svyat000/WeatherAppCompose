package com.sddrozdov.weatherappcompose.models

import com.sddrozdov.weatherappcompose.Current
import com.sddrozdov.weatherappcompose.Location

data class WeatherResponse(
    val location: Location,
    val current: Current
)