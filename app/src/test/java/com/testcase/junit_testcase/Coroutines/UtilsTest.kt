package com.testcase.junit_testcase.Coroutines

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class UtilsTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    /*    // all coroutines (Dispatchers.Main, Dispatchers.IO) run in one StandardTestDispatcher (one thread)
        val testDispatcher = StandardTestDispatcher()

        @Before
        fun setUp(){
            //set main Dispatchers
            Dispatchers.setMain(testDispatcher)
        }*/

    @Test
    fun testGetUser() {
        val sut = Utils(mainCoroutineRule.testDispatcher)

        //runTest use for avoid delay, optimization and fast run
        runTest {
            sut.getAddress()
        }
    }

    @Test
    fun testGetUser2() {
        val sut = Utils(mainCoroutineRule.testDispatcher)

        //runTest use for avoid delay, optimization and fast run
        runTest {
            sut.getAddressDetail()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle() // run all coroutine in queue and wait until run using advanceUntilIdle method
            Assert.assertEquals(true, sut.globalArg)
        }
    }
    /*   @After
       fun tearDown(){
           Dispatchers.resetMain()
       }*/
}