package com.testcase.junit_testcase.MVVM.ViewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.testcase.prectice.Api.MyResponse
import com.testcase.prectice.ViewModel.NewsRepository
import com.testcase.prectice.ViewModel.NewsViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NewsViewModelTest {


    // all coroutines (Dispatchers.Main, Dispatchers.IO) run in one StandardTestDispatcher (one thread)
    private var testDispatcher = StandardTestDispatcher()

    // use : add rule for architecture component to run task as synchronously, we try generate less thread for test case
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var newsRepository: NewsRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun test_getNews() = runTest {
        Mockito.`when`(newsRepository.callApi()).thenReturn(MyResponse.Success(emptyList()))

        val sut = NewsViewModel(newsRepository)
        sut.getNews()
        testDispatcher.scheduler.advanceUntilIdle() // run all coroutine in queue and wait until run using advanceUntilIdle method
        val result = sut.newsData.getOrAwaitValue()
        Assert.assertEquals(0,result.data1!!.size)
    }
    @Test
    fun test_getNews_expected_error() = runTest {
        Mockito.`when`(newsRepository.callApi()).thenReturn(MyResponse.Error(NullPointerException()))

        val sut = NewsViewModel(newsRepository)
        sut.getNews()
        testDispatcher.scheduler.advanceUntilIdle() // run all coroutine in queue and wait until run using advanceUntilIdle method
        val result = sut.newsData.getOrAwaitValue()
        Assert.assertEquals(NullPointerException().message,result.exception1!!.message)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}