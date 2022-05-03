package com.audev.framework.mvvm.di

import com.audev.framework.mvvm.di.scopes.ActivityScoped
import com.audev.framework.mvvm.ui.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}