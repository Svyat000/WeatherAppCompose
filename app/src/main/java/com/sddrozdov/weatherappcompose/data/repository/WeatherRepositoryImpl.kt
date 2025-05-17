package com.sddrozdov.weatherappcompose.data.repository

import com.sddrozdov.weatherappcompose.Constants.Const
import com.sddrozdov.weatherappcompose.data.api.WeatherApi
import com.sddrozdov.weatherappcompose.data.weatherMapper.toDomainModel
import com.sddrozdov.weatherappcompose.domain.model.Weather
import com.sddrozdov.weatherappcompose.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeather(city: String): Weather {
        val response = api.getWeatherWithDays(
            apiKey = Const.API_KEY,
            location = city,
            days = 3
        )
        return response.toDomainModel()
    }
}

