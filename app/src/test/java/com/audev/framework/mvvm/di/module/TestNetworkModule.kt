package com.audev.framework.mvvm.di.module

import com.audev.framework.mvvm.data.DataSource
import com.audev.framework.mvvm.network.ApiService
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import okhttp3.CacheControl
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit

import okhttp3.mockwebserver.MockWebServer

import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

@Module
class TestNetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): MockWebServer {
        return MockWebServer()
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        val gson = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
        return gson
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gson: Gson,
        server: MockWebServer
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

}