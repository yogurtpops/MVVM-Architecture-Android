package com.audev.framework.mvvm.network

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.audev.framework.mvvm.data.remote.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /**
     * Get repos ordered by stars.
     */
    @GET("search/repositories?sort=stars")
    suspend fun searchRepos(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): RepoSearchResponse

    @GET("users")
    suspend fun getUsers(): List<User>

}