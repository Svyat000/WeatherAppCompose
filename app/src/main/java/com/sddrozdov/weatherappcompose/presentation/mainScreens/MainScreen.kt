package com.sddrozdov.weatherappcompose.presentation.mainScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sddrozdov.weatherappcompose.presentation.state.MainScreenState
import com.sddrozdov.weatherappcompose.presentation.state.WeatherScreenEvent
import com.sddrozdov.weatherappcompose.presentation.viewModel.MainScreenViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    var searchQuery by remember { mutableStateOf(state.city) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth(),
            query = searchQuery,
            onQueryChange = {
                searchQuery = it
                viewModel.onEvent(WeatherScreenEvent.CityUpdated(it))
            },
            onSearch = { viewModel.onEvent(WeatherScreenEvent.RefreshWeather) },
            active = false,
            onActiveChange = {},
            colors = SearchBarDefaults.colors(
                containerColor = Color(0xFFAACBF1),
            ),
            placeholder = {
                Text(
                    "Введите название города",
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        ) {}

        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    LoadingIndicator()
                }
            }

            state.error != null -> ErrorMessage(
                message = state.error!!,
                modifier = Modifier.padding(top = 24.dp)
            )

            state.currentWeather != null -> WeatherContent(state)

            else -> Text(
                text = "Введите название города",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally),
                color = Blue,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun WeatherContent(state: MainScreenState) {
    Column(
        modifier = Modifier.padding(top = 16.dp)
    ) {
        state.currentWeather?.let {
            CurrentWeatherCard(weather = it)
            TabLayout(forecast = it.forecastDays)
        }
    }
}