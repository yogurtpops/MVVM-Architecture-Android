package com.mindorks.framework.mvvm

import android.app.Application
import com.mindorks.framework.mvvm.di.AppComponent
import com.mindorks.framework.mvvm.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return initializeDaggerComponent()
    }

    open fun initializeDaggerComponent(): AppComponent {
        val component: AppComponent = DaggerAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }


}