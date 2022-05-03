package com.mindorks.framework.mvvm.di

import com.mindorks.framework.mvvm.di.scopes.ActivityScoped
import com.mindorks.framework.mvvm.ui.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}