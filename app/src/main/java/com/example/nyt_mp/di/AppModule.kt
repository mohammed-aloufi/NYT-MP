package com.example.nyt_mp.di

import android.content.Context
import com.example.nyt_mp.data.remote.MostPopularApiService
import com.example.nyt_mp.data.repository.MostPopularArticleRepoImpl
import com.example.nyt_mp.domain.repository.MostPopularArticleRepo
import com.example.nyt_mp.domain.usecase.FilterArticlesUseCase
import com.example.nyt_mp.domain.usecase.GetSectionListUseCase
import com.example.nyt_mp.utils.ConnectivityObserver
import com.example.nyt_mp.utils.ConnectivityObserverImpl
import com.example.nyt_mp.utils.Constants.BASE_URL
import com.example.nyt_mp.utils.DefaultDispatchers
import com.example.nyt_mp.utils.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
            .baseUrl(BASE_URL)
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

    @Singleton
    @Provides
    fun provideConnectivityObserver(
        @ApplicationContext context: Context,
    ): ConnectivityObserver {
        return ConnectivityObserverImpl(context)
    }

    @Singleton
    @Provides
    fun provideGetSectionListUseCase() = GetSectionListUseCase()

    @Singleton
    @Provides
    fun provideFilterArticlesUseCase() = FilterArticlesUseCase()

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider {
        return DefaultDispatchers()
    }
}