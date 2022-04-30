package com.mindorks.framework.mvvm

import android.app.Application
import com.mindorks.framework.mvvm.dagger.AppComponent
import com.mindorks.framework.mvvm.dagger.AppModule
import com.mindorks.framework.mvvm.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : Application() {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

    fun appComp() = appComponent
}