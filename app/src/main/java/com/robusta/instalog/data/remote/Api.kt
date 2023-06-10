package com.robusta.instalog.data.remote

import com.robusta.instalog.domain.entity.CurrentDayForecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET(URLs.URL_GET_CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") tempUnit : String= "metric",
    ): Response<CurrentDayForecast>
}