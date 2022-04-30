package com.mindorks.framework.mvvm.data.repository

import com.mindorks.framework.mvvm.data.model.User
import io.reactivex.Single

interface Repository {
    fun getUsers(): Single<List<User>>
}