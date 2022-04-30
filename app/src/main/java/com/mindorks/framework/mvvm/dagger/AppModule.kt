package com.mindorks.framework.mvvm.dagger

import android.content.Context
import com.mindorks.framework.mvvm.data.api.ApiHelper
import com.mindorks.framework.mvvm.data.api.ApiService
import com.mindorks.framework.mvvm.data.api.ApiServiceImpl
import com.mindorks.framework.mvvm.data.repository.MainRepository
import com.mindorks.framework.mvvm.data.repository.Repository
import com.mindorks.framework.mvvm.ui.main.viewmodel.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideMainViewModel(repo: Repository): MainViewModel =
            MainViewModel(repo)

//        @JvmStatic
//        @Provides
//        @Singleton
//        fun provideApiService(): ApiService =
//            ApiServiceImpl()

        @JvmStatic
        @Provides
        @Singleton
        fun provideApiHelper(repo: ApiService): ApiHelper =
            ApiHelper(repo)
    }

//    @Binds
//    abstract fun provideMainViewModel(repoImpl: MainViewModel): MainViewModel

    @Binds
    abstract fun provideApiService(repoImpl: ApiServiceImpl): ApiService

//    @Binds
//    abstract fun provideApiHelper(repoImpl: ApiHelper): ApiHelper

    @Binds
    abstract fun provideRepository(repoImpl: MainRepository): Repository

}