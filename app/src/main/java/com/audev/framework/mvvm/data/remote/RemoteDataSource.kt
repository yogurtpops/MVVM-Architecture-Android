package com.audev.framework.mvvm.data.remote

import com.audev.framework.mvvm.data.DataSource
import com.audev.framework.mvvm.network.ApiService
import com.audev.framework.mvvm.data.remote.model.User
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : DataSource {

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }

}