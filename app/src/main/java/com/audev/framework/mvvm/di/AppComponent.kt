package com.audev.framework.mvvm.di

import android.content.Context
import com.audev.framework.mvvm.di.viewmodel.ViewModelModule
import com.audev.framework.mvvm.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, AppModule::class, ViewModelModule::class, AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class, ActivityBindingModule::class])
@Singleton
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}