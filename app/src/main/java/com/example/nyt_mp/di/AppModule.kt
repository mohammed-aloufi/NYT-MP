package com.example.nyt_mp.di

import com.example.nyt_mp.BuildConfig
import com.example.nyt_mp.data.remote.MostPopularApiService
import com.example.nyt_mp.data.repository.MostPopularArticleRepoImpl
import com.example.nyt_mp.domain.repository.MostPopularArticleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttpClientV2(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .callTimeout(2, TimeUnit.MINUTES)
        .build()

    @Provides
    @Singleton
    fun provideMostPopularApiService(
        okHttpClient: OkHttpClient,
    ): MostPopularApiService {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.NY_TIME_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(MostPopularApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMostPopularArticleRepo(apiService: MostPopularApiService): MostPopularArticleRepo {
        return MostPopularArticleRepoImpl(apiService)
    }
}