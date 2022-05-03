package com.audev.framework.mvvm.data

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.audev.framework.mvvm.data.remote.model.User

interface DataSource {

    suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse

    suspend fun getUsers(): List<User>

}