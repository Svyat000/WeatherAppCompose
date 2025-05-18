package com.sddrozdov.weatherappcompose.presentation.mainScreens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.sddrozdov.weatherappcompose.domain.model.DailyForecast
import com.sddrozdov.weatherappcompose.domain.model.Weather

@Composable
fun DailyForecastList(dailyForecast: List<DailyForecast>) {
    LazyColumn {
        items(dailyForecast) { forecast ->
            ListItem(
                weather = Weather(
                    city = forecast.date,
                    localTime = "",
                    currentTemp = forecast.maxTemp,
                    condition = forecast.condition,
                    iconUrl = forecast.iconUrl,
                    tempMax = forecast.maxTemp,
                    tempMin = forecast.minTemp,
                    forecastDays = emptyList()
                )
            )
        }
    }
}