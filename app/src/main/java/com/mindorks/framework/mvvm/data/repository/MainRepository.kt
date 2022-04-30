package com.mindorks.framework.mvvm.data.repository

import com.mindorks.framework.mvvm.data.api.ApiHelper
import com.mindorks.framework.mvvm.data.model.User
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(val apiHelper: ApiHelper) : Repository {

    override fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }

}