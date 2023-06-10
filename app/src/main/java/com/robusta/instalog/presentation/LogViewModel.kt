package com.robusta.instalog.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.robusta.instalog.domain.entity.CurrentDayForecast
import com.robusta.instalog.domain.usecase.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogViewModel @Inject constructor (private val getWeatherUseCase: GetWeatherUseCase) :
    ViewModel() {

    private val _currentWeather: MutableStateFlow<CurrentDayForecast?> = MutableStateFlow(null)
    val currentWeather: StateFlow<CurrentDayForecast?> = _currentWeather

    fun getCurrentWeatherData(lat: String, lng: String) {
        viewModelScope.launch {
            try {
                val response = getWeatherUseCase.getCurrentWeatherLatLon(lat, lng)
                if (response.isSuccessful) {
                    _currentWeather.value =
                        getWeatherUseCase.getCurrentWeatherLatLon(lat, lng).body()
                }
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
            }
        }
    }
}