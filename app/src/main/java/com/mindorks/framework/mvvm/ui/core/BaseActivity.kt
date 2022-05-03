//package com.mindorks.framework.mvvm.ui.core
//
//import androidx.lifecycle.ViewModel
//import dagger.android.support.DaggerAppCompatActivity
//import android.os.Bundle
//
//abstract class BaseActivity<T : ViewModel?> : DaggerAppCompatActivity() {
//    private var viewModel: T? = null
//
//    /**
//     *
//     * @return view model instance
//     */
//    abstract fun getViewModel(): T
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewModel = if (viewModel == null) getViewModel() else viewModel
//    }
//}