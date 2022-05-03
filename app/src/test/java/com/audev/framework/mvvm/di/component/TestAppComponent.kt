package com.audev.framework.mvvm.di.component

import android.content.Context
import com.audev.framework.mvvm.di.viewmodel.ViewModelModule
import com.audev.framework.mvvm.data.DefaultDataRepositoryTest
import com.audev.framework.mvvm.di.module.TestAppModule
import com.audev.framework.mvvm.di.ActivityBindingModule
import com.audev.framework.mvvm.di.AppComponent
import com.audev.framework.mvvm.di.AppModule
import com.audev.framework.mvvm.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class, NetworkModule::class,
        TestAppModule::class, AppModule::class,
        ViewModelModule::class, ActivityBindingModule::class
    ]
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }

//    fun inject(app: TestBaseApplication)

    fun inject(test: DefaultDataRepositoryTest)

}