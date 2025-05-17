package com.sddrozdov.weatherappcompose.domain.model

data class Weather(
    val city: String,
    val localTime: String,
    val currentTemp: Double,
    val condition: String,
    val iconUrl: String,
    val tempMax: Double,
    val tempMin: Double,
    val forecastDays: List<DailyForecast>
)

data class DailyForecast(
    val date: String,
    val maxTemp: Double,
    val minTemp: Double,
    val condition: String,
    val iconUrl: String,
    val hourlyForecast: List<HourlyForecast>
)

data class HourlyForecast(
    val time: String,
    val temp: Double,
    val condition: String,
    val iconUrl: String
)