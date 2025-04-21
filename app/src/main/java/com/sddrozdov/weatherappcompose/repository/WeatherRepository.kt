package com.sddrozdov.weatherappcompose.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.sddrozdov.weatherappcompose.Constants.Const
import com.sddrozdov.weatherappcompose.api.ApiClient
import com.sddrozdov.weatherappcompose.models.WeatherResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherRepository {

    fun getWeather(
        scope: CoroutineScope,
        location: String,
        state: MutableState<String>,
        context: Context,
        onSuccess: (WeatherResponse) -> Unit,
    )  {
        val apiKey = Const.API_KEY

        scope.launch(Dispatchers.IO) {
            try {
                val response = ApiClient.weatherApi.getWeatherWithDays(apiKey, location, 3)
                onSuccess(response)
//                withContext(Dispatchers.Main) {
//                    state.value = "$response"
//                    Toast.makeText(
//                        context.applicationContext,
//                        "Updated: ${response.location.localtime}",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
                val city = response.location.name

                val days = response.forecast.forecastDays

                Log.d("MYTAGGG", "$response")
                Log.d("MYTAGGG", "${response.forecast.forecastDays}")
                for (i in response.forecast.forecastDays) {
                    val dayys = i.hour
                    Log.d("MYTAGGG", "$dayys")
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    state.value = "Error"
                    Toast.makeText(
                        context.applicationContext,
                        "Error: ${e.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}