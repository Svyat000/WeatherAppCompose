package com.sddrozdov.weatherappcompose.presentation.state

import com.sddrozdov.weatherappcompose.domain.model.Weather

data class MainScreenState(
    val city: String = "",
    val currentWeather: Weather? = null,
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val error: String? = null,
    val selectedTab: WeatherTab = WeatherTab.HOURLY
)

enum class WeatherTab {
    HOURLY, DAILY
}

sealed class WeatherScreenEvent {
    data class CityUpdated(val newCity: String) : WeatherScreenEvent()
    data object RefreshWeather : WeatherScreenEvent()
    data class TabSelected(val tab: WeatherTab) : WeatherScreenEvent()
}
