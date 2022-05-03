package com.mindorks.framework.mvvm.data

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.mindorks.framework.mvvm.data.remote.model.User
import io.reactivex.Single

interface DataRepository {

    suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): Result<RepoSearchResponse>

    suspend fun getUsers(): Result<List<User>>

}