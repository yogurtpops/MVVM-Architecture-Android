package com.audev.framework.mvvm.data

import com.audev.framework.mvvm.data.remote.model.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class DefaultDataRepositoryTest {

    lateinit var dataRepository: DefaultDataRepository
    private val remoteDataSource: DataSource = mockk()

    @Before
    fun setup() {
        dataRepository = DefaultDataRepository(remoteDataSource)
    }

//    @ExperimentalCoroutinesApi
//    @Test
//    fun getSearchResponse() = runBlockingTest {
//        val repoList = mutableListOf<Repo>()
//        val repo = Repo(1, "test_repo", "test_name", "test_desc", "test_url", 1, 1, "en")
//        repoList.add(repo)
//        val response = RepoSearchResponse(1, repoList)
//
//        coEvery { remoteDataSource.getSearchResponse("android", 1, 1) } returns response
//
//        dataRepository.getUsers()
//
//        coVerify { remoteDataSource.getSearchResponse("android", 1, 1) }
//    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUsersResponse() = runBlockingTest {
        dataRepository.getUsers()
        val response  = listOf<User>()
        coEvery { remoteDataSource.getUsers() } returns response
    }
}