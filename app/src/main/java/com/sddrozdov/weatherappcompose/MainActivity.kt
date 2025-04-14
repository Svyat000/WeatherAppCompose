package com.sddrozdov.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sddrozdov.weatherappcompose.repository.WeatherRepository
import com.sddrozdov.weatherappcompose.ui.screens.MainCard
import com.sddrozdov.weatherappcompose.ui.screens.TabLayout
import com.sddrozdov.weatherappcompose.ui.theme.WeatherAppComposeTheme
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppComposeTheme {
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
fun Greeting(city: String) {
    val weatherRepository = WeatherRepository()

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
                        weatherRepository.getWeather(
                            scope = scope,
                            location = city,
                            state = state,
                            context = context
                        )
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














