package com.audev.framework.mvvm.data.remote

import com.audev.framework.mvvm.data.DataSource
import com.example.dagger.data.remote.model.RepoSearchResponse
import com.audev.framework.mvvm.network.ApiService
import com.audev.framework.mvvm.data.remote.model.User
import javax.inject.Inject


class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : DataSource {

    private val IN_QUALIFIER = "in:name,description"

    override suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse {
        return apiService.searchRepos(
            "$query $IN_QUALIFIER",
            page,
            itemsPerPage
        )
    }

    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }

}