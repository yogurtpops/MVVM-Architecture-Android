package com.audev.framework.mvvm.data

import com.audev.framework.mvvm.data.remote.model.User

interface DataRepository {

    suspend fun getUsers(): Result<List<User>>

}