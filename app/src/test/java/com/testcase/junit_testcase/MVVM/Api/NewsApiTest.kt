package com.testcase.junit_testcase.MVVM.Api

import com.testcase.junit_testcase.Helper
import com.testcase.prectice.Api.NewsApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiTest {

    lateinit var mockWebServer: MockWebServer
    lateinit var newsApi: NewsApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        newsApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @Test
    fun testGetNews()  = runTest{
        val mockResponse = MockResponse()
        mockResponse.setBody("{\"status\":\"success\",\"totalResults\":224002,\"results\":[]}")

        mockWebServer.enqueue(mockResponse)  // add response in queue

        val response = newsApi.newsApi(anyString())

        mockWebServer.takeRequest() // take all request

        Assert.assertEquals(true, response.body()!!.results.isEmpty())

    }
    @Test
    fun testGetNews_expectedValues()  = runTest{
        val mockResponse = MockResponse()

        val content =  Helper.readFromResource("/response.json")

        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)

        mockWebServer.enqueue(mockResponse)  // add response in queue

        val response = newsApi.newsApi(anyString())

        mockWebServer.takeRequest() // take all request

        Assert.assertEquals(2, response.body()!!.results.size)

    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}