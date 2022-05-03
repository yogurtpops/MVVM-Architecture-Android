package com.mindorks.framework.mvvm.di

import com.mindorks.framework.mvvm.data.DataRepository
import com.mindorks.framework.mvvm.data.DataSource
import com.mindorks.framework.mvvm.data.DefaultDataRepository
import com.mindorks.framework.mvvm.data.remote.RemoteDataSource
import com.mindorks.framework.mvvm.network.ApiService
import com.mindorks.framework.mvvm.ui.viewmodel.MainViewModel
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