package com.testcase.junit_testcase.MVVM.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.testcase.junit_testcase.Coroutines.MainCoroutineRule
import com.testcase.prectice.Api.Model.NewsModel
import com.testcase.prectice.Api.MyResponse
import com.testcase.prectice.Api.NewsApi
import com.testcase.prectice.ViewModel.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class NewsRepositoryTest {

    // all coroutines (Dispatchers.Main, Dispatchers.IO) run in one StandardTestDispatcher (one thread)
    private var testDispatcher = StandardTestDispatcher()

    // use : add rule for architecture component to run task as synchronously, we try generate less thread for test case
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var  newsApi: NewsApi
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun testGetNews_emptyList() = runTest{

        val newsModel = NewsModel(emptyList(),"true",0)
        Mockito.`when`(newsApi.newsApi(anyString())).thenReturn(Response.success(newsModel))

        val sut = NewsRepository(newsApi)
        val result = sut.callApi()
        testDispatcher.scheduler.advanceUntilIdle()
        Assert.assertEquals(true, result is MyResponse.Success)
    }



    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}