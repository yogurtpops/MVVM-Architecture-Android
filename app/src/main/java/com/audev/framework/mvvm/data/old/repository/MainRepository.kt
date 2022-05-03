//package com.mindorks.framework.mvvm.data.old.repository
//
//import com.mindorks.framework.mvvm.data.old.api.ApiHelper
//import com.mindorks.framework.mvvm.data.remote.model.User
//import io.reactivex.Single
//import javax.inject.Inject
//import javax.inject.Singleton
//
//@Singleton
//class MainRepository @Inject constructor(val apiHelper: ApiHelper) : Repository {
//
//    override fun getUsers(): Single<List<User>> {
//        return apiHelper.getUsers()
//    }
//
//}