package com.sddrozdov.weatherappcompose

import android.content.Context
import android.os.Bundle
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sddrozdov.weatherappcompose.ui.theme.WeatherAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherAppComposeTheme {
                Greeting("12as")
            }
        }
    }
}

@Composable
fun Greeting(city: String) {

    val state = remember {
        mutableStateOf("Null")
    }

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
                    //getResult(city)
                }, modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "TEST BUTTON")
            }
        }
    }
}

@Composable
private fun getResult(city: String, state: MutableState<String>, context: Context) {
    val url = ""
}
