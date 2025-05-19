package com.sddrozdov.weatherappcompose.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sddrozdov.weatherappcompose.domain.repository.WeatherRepository
import com.sddrozdov.weatherappcompose.presentation.state.MainScreenState
import com.sddrozdov.weatherappcompose.presentation.state.WeatherScreenEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val repository: WeatherRepository) :
    ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState> = _state

    fun onEvent(event: WeatherScreenEvent) {
        when (event) {
            is WeatherScreenEvent.CityUpdated -> {
                _state.update { it.copy(city = event.newCity) }
                loadWeather()
            }

            WeatherScreenEvent.RefreshWeather -> {
                _state.update { it.copy(isRefreshing = true) }
                loadWeather()
            }

            is WeatherScreenEvent.TabSelected -> {
                _state.update { it.copy(selectedTab = event.tab) }
            }
        }
    }

    private fun loadWeather() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = !it.isRefreshing,
                    error = null
                )
            }

            try {
                val weather = repository.getWeather(_state.value.city)
                _state.update {
                    it.copy(
                        currentWeather = weather,
                        isLoading = false,
                        isRefreshing = false
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        error = e.message ?: "Unknown error",
                        isLoading = false,
                        isRefreshing = false
                    )
                }
            }
        }
    }
}