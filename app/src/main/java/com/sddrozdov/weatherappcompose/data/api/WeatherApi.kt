package com.sddrozdov.weatherappcompose.data.api

import com.sddrozdov.weatherappcompose.data.dto.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String,
    ): WeatherResponse

    @GET("forecast.json")
    suspend fun getWeatherWithDays(
        @Query("key") apiKey: String,
        @Query("q") location: String,
        @Query("days") days: Int
    ): WeatherResponse
}