package com.example.nyt_mp.di

import com.example.nyt_mp.BuildConfig
import com.example.nyt_mp.data.remote.MostPopularApiService
import com.example.nyt_mp.data.remote.PagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMostPopularApiService(): MostPopularApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.NY_TIME_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MostPopularApiService::class.java)
    }

}