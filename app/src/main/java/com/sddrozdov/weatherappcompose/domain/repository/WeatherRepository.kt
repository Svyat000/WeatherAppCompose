package com.sddrozdov.weatherappcompose.domain.repository

import com.sddrozdov.weatherappcompose.domain.model.Weather

interface WeatherRepository {
    suspend fun getWeather(city: String) : Weather
}