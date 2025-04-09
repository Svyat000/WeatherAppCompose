package com.sddrozdov.weatherappcompose.repository

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.sddrozdov.weatherappcompose.Constants.Const
import com.sddrozdov.weatherappcompose.api.ApiClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WeatherRepository {

    fun getWeather(
        scope: CoroutineScope,
        location: String,
        state: MutableState<String>,
        context: Context
    ) {
        val apiKey = Const.API_KEY

        scope.launch(Dispatchers.IO) {
            try {
                val response = ApiClient.weatherApi.getCurrentWeather(apiKey, location)
                withContext(Dispatchers.Main) {
                    state.value = "${response.current.temp_c} C"
                    Toast.makeText(
                        context,
                        "Updated: ${response.location.localtime}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    state.value = "Error"
                    Toast.makeText(
                        context,
                        "Error: ${e.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}