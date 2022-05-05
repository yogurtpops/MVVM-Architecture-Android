package com.audev.framework.mvvm.data

import com.audev.framework.mvvm.data.remote.model.User

interface DataSource {

    suspend fun getUsers(): List<User>

}