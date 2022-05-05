package com.audev.framework.mvvm

import com.audev.framework.mvvm.di.AppComponent
import com.audev.framework.mvvm.di.component.DaggerTestAppComponent
import com.audev.framework.mvvm.di.component.TestAppComponent


class TestBaseApplication : App() {

    override fun initializeDaggerComponent(): AppComponent {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }

}