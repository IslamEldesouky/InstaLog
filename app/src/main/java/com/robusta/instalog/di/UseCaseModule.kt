package com.robusta.instalog.di

import com.robusta.instalog.domain.repo.WeatherRepo
import com.robusta.instalog.domain.usecase.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetWeatherUseCase(weatherRepo: WeatherRepo): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepo)
    }
}