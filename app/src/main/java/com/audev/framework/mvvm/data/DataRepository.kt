package com.audev.framework.mvvm.data

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.audev.framework.mvvm.data.remote.model.User

interface DataRepository {

    suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): Result<RepoSearchResponse>

    suspend fun getUsers(): Result<List<User>>

}