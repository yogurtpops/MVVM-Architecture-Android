package com.mindorks.framework.mvvm.data.remote

import com.mindorks.framework.mvvm.data.DataSource
import com.example.dagger.data.remote.model.RepoSearchResponse
import com.mindorks.framework.mvvm.network.ApiService
import com.mindorks.framework.mvvm.data.remote.model.User
import io.reactivex.Single
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