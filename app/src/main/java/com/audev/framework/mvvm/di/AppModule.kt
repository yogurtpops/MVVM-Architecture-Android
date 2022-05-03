package com.audev.framework.mvvm.di

import com.audev.framework.mvvm.data.DataRepository
import com.audev.framework.mvvm.data.DataSource
import com.audev.framework.mvvm.data.DefaultDataRepository
import com.audev.framework.mvvm.data.remote.RemoteDataSource
import com.audev.framework.mvvm.network.ApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun bindDataRepository(defaultDataRepository: DefaultDataRepository): DataRepository

    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideTasksRemoteDataSource(
            apiService: ApiService
        ): DataSource {
            return RemoteDataSource(apiService)
        }
    }
}