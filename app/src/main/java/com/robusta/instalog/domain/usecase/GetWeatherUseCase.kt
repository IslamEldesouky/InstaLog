package com.robusta.instalog.domain.usecase

import com.robusta.instalog.domain.repo.WeatherRepo

class GetWeatherUseCase(private val weatherRepo: WeatherRepo) {
    suspend fun getCurrentWeatherLatLon(lat: String, lon: String) =
        weatherRepo.getCurrentWeather(lat, lon)
}