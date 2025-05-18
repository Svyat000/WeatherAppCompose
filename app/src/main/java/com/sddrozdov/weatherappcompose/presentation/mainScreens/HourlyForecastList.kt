package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.sddrozdov.weatherappcompose.domain.model.HourlyForecast
import com.sddrozdov.weatherappcompose.domain.model.Weather

@Composable
fun HourlyForecastList(hourlyForecast: List<HourlyForecast>) {
    LazyColumn {
        items(hourlyForecast) { forecast ->
            ListItem(weather = Weather(
                city = "",
                localTime = forecast.time,
                currentTemp = forecast.temp,
                condition = forecast.condition,
                iconUrl = forecast.iconUrl,
                tempMax = 0.0,
                tempMin = 0.0,
                forecastDays = emptyList()
            )
            )
        }
    }
}