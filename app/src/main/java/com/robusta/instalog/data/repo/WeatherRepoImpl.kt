package com.robusta.instalog.data.repo

import com.robusta.instalog.data.remote.Api
import com.robusta.instalog.domain.entity.CurrentDayForecast
import com.robusta.instalog.domain.repo.WeatherRepo
import retrofit2.Response

class WeatherRepoImpl(private val api: Api) : WeatherRepo {
    override suspend fun getCurrentWeather(lat: String, lon: String): Response<CurrentDayForecast> =
        api.getCurrentWeather(lat, lon)
}