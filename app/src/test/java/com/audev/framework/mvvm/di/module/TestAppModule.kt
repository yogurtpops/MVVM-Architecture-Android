package com.audev.framework.mvvm.di.module

import com.audev.framework.mvvm.data.DataSource
import com.audev.framework.mvvm.network.ApiService
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

/**
Created by Prokash Sarkar on Mon, February 08, 2021
Copyright (c) 2021 Augmedix. All rights reserved.
 **/

@Module
class TestAppModule {

    @Singleton
    @Provides
    fun provideTasksRemoteDataSource(
        apiService: ApiService
    ): DataSource {
        return mockk()
    }

}