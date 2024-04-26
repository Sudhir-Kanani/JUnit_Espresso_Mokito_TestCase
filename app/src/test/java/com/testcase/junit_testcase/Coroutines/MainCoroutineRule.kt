package com.testcase.junit_testcase.Coroutines

import android.text.TextWatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutineRule :   TestWatcher() {
    val testDispatcher = StandardTestDispatcher()

    // @before Code
    override fun starting(description: Description?) {
        Dispatchers.setMain(testDispatcher)
        super.starting(description)
    }

    // @After Code
    override fun finished(description: Description?) {
        Dispatchers.resetMain()
        super.finished(description)
    }
}