package com.mindorks.framework.mvvm.data

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.mindorks.framework.mvvm.data.remote.model.User
import io.reactivex.Single

interface DataSource {

    suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): RepoSearchResponse

    suspend fun getUsers(): List<User>

}