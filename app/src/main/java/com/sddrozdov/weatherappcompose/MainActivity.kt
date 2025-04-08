package com.sddrozdov.weatherappcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.sddrozdov.weatherappcompose.Constants.Const
import com.sddrozdov.weatherappcompose.ui.theme.WeatherAppComposeTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppComposeTheme {
                Greeting("Volgograd")
            }
        }
    }
}

@Composable
fun Greeting(city: String) {

    val state = remember {
        mutableStateOf("Null")
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .background(Color.Gray), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "temp in $city = ${state.value}",
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.DarkGray),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = {
                    scope.launch {
                        getWeather(scope = this, location = city, state = state, context = context)
                    }
                }, modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "TEST BUTTON")
            }
        }
    }
}

interface WeatherApi {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") location: String
    ): WeatherResponse
}

data class WeatherResponse(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime: String
)

data class Current(
    val temp_c: Double,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)

object ApiClient {
    private const val BASE_URL = "https://api.weatherapi.com/v1/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val weatherApi: WeatherApi by lazy {
        retrofit.create(WeatherApi::class.java)
    }
}

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


