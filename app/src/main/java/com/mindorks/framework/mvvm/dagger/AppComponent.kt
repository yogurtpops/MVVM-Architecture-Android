package com.mindorks.framework.mvvm.dagger

import com.mindorks.framework.mvvm.ui.main.view.MainActivity
import com.mindorks.framework.mvvm.ui.main.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}