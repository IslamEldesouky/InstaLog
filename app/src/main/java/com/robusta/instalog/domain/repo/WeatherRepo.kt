package com.robusta.instalog.domain.repo

import com.robusta.instalog.domain.entity.CurrentDayForecast
import retrofit2.Response

interface WeatherRepo {
    suspend fun getCurrentWeather(
        lat: String,
        lon: String,
    ): Response<CurrentDayForecast>
}