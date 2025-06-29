package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sddrozdov.weatherappcompose.domain.model.HourlyForecast
import com.sddrozdov.weatherappcompose.domain.model.Weather

@Composable
fun HourlyForecastList(hourlyForecast: List<HourlyForecast>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 8.dp, horizontal = 12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(hourlyForecast) { forecast ->
            ListItem(
                weather = Weather(
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