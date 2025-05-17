package com.sddrozdov.weatherappcompose.data.weatherMapper

import com.sddrozdov.weatherappcompose.data.dto.ForecastDay
import com.sddrozdov.weatherappcompose.data.dto.Hour
import com.sddrozdov.weatherappcompose.data.dto.WeatherResponse
import com.sddrozdov.weatherappcompose.domain.model.DailyForecast
import com.sddrozdov.weatherappcompose.domain.model.HourlyForecast
import com.sddrozdov.weatherappcompose.domain.model.Weather

internal fun WeatherResponse.toDomainModel() = Weather(
    city = location.name,
    localTime = location.localtime,
    currentTemp = current.temp_c,
    condition = current.condition.text,
    iconUrl = current.condition.icon,
    tempMax = forecast.forecastDays.first().day.maxTempC,
    tempMin = forecast.forecastDays.first().day.minTempC,
    forecastDays = forecast.forecastDays.map { it.toDomainModel() }
)

internal fun ForecastDay.toDomainModel() = DailyForecast(
    date = date,
    maxTemp = day.maxTempC,
    minTemp = day.minTempC,
    condition = day.condition.text,
    iconUrl = day.condition.icon,
    hourlyForecast = hour.map { it.toDomainModel() }
)

internal fun Hour.toDomainModel() = HourlyForecast(
    time = time,
    temp = tempC,
    condition = condition.text,
    iconUrl = condition.icon
)