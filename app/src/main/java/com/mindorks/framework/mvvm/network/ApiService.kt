package com.mindorks.framework.mvvm.network

import com.example.dagger.data.remote.model.RepoSearchResponse
import com.mindorks.framework.mvvm.data.remote.model.User
import io.reactivex.Single
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