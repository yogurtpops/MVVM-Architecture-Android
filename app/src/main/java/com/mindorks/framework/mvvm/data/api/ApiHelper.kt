package com.mindorks.framework.mvvm.data.api

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiHelper @Inject constructor(val apiService: ApiService) {

    fun getUsers() = apiService.getUsers()

}