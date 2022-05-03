package com.audev.framework.mvvm.data

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.audev.framework.mvvm.data.remote.model.User
import javax.inject.Inject

class DefaultDataRepository @Inject constructor(
    private val remoteDataSource: DataSource
) : DataRepository {

    override suspend fun getSearchResponse(
        query: String,
        page: Int,
        itemsPerPage: Int
    ): Result<RepoSearchResponse> {
        return try {
            val result = remoteDataSource.getSearchResponse(query, page, itemsPerPage)
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getUsers(): Result<List<User>> {
        return try {
            val result = remoteDataSource.getUsers()
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

}