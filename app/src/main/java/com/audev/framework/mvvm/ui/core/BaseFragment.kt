//package com.mindorks.framework.mvvm.ui.core
//
//import android.content.Context
//import androidx.lifecycle.ViewModel
//import dagger.android.DaggerFragment
//
//abstract class BaseFragment<T : ViewModel?> : DaggerFragment() {
//    private var viewModel: T? = null
//
//    /**
//     *
//     * @return view model instance
//     */
//    abstract fun getViewModel(): T
//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        viewModel = getViewModel()
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//    }
//}