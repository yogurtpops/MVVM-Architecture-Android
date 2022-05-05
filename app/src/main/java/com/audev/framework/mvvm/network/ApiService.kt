package com.audev.framework.mvvm.network

import com.audev.framework.mvvm.data.remote.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}