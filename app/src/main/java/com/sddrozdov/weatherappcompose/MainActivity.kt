package com.sddrozdov.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import com.sddrozdov.weatherappcompose.repository.WeatherRepository
import com.sddrozdov.weatherappcompose.ui.screens.MainCard
import com.sddrozdov.weatherappcompose.ui.screens.TabLayout
import com.sddrozdov.weatherappcompose.ui.theme.WeatherAppComposeTheme



class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppComposeTheme {

                GetWeather("Volgograd")

                Image(
                    painter = painterResource(R.drawable.sky_background),
                    contentDescription = "skyback",
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(0.7f),
                    contentScale = ContentScale.FillBounds
                )
                Column() {
                    MainCard()
                    TabLayout()
                }
            }
        }
    }
}

@Composable
fun GetWeather(city: String) {
    val weatherRepository = WeatherRepository()

    val state = remember {
        mutableStateOf("Load")
    }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    LaunchedEffect(city){
        weatherRepository.getWeather(scope = scope, location = city,state = state, context = context)
    }
}














