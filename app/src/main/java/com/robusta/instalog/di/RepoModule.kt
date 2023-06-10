package com.robusta.instalog.di

import com.robusta.instalog.data.remote.Api
import com.robusta.instalog.data.repo.WeatherRepoImpl
import com.robusta.instalog.domain.repo.WeatherRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
 object RepoModule {

    @Provides
    fun provideRepo(api: Api): WeatherRepo {
        return WeatherRepoImpl(api)
    }
}