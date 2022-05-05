package com.audev.framework.mvvm.data

import com.audev.framework.mvvm.TestBaseApplication
import com.audev.framework.mvvm.di.component.DaggerTestAppComponent
import com.audev.framework.mvvm.di.component.TestAppComponent
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Test
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import javax.inject.Inject

class DefaultDataRepositoryTest {

    @Inject
    lateinit var dataRepository: DefaultDataRepository

    @Inject
    lateinit var server: MockWebServer

    @Before
    fun setup() {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(TestBaseApplication())
        component.inject(this)
    }

    private fun enqueueMockResponse(response: String) {
        javaClass.classLoader?.let {
            val mockResponse = MockResponse()
            mockResponse.setBody(response)
            server.enqueue(mockResponse)
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getUsersResponse() = runBlockingTest {
        //Setup mock response
        enqueueMockResponse("[{\"id\":\"1\",\"name\":\"Dr. Edwin Orn\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/sunlandictwin/128.jpg\",\"email\":\"Connor.Hartmann71@gmail.com\"},{\"id\":\"2\",\"name\":\"Alford Hoeger\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/fuck_you_two/128.jpg\",\"email\":\"Rick83@gmail.com\"},{\"id\":\"3\",\"name\":\"Terrance Halvorson\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/mufaddal_mw/128.jpg\",\"email\":\"Kenton_Wisozk@hotmail.com\"},{\"id\":\"4\",\"name\":\"Morgan McGlynn\",\"avatar\":\"https://s3.amazonaws.com/uifaces/faces/twitter/allfordesign/128.jpg\",\"email\":\"Adah_Streich14@gmail.com\"}]")

        //Send Request to the MockServer
        val responseBody = dataRepository.getUsers()

        //Request received by the mock server
        val request = server.takeRequest()
        assertThat(responseBody).isNotNull()
        assertThat(request.path).isEqualTo("/users")

    }
}