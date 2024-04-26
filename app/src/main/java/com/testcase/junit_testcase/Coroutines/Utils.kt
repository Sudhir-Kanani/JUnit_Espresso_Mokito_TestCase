package com.testcase.junit_testcase.Coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Utils(val dispatcher : CoroutineDispatcher) {
    suspend fun getUserName(): String {
        delay(10000)
        return "TestCase"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch{
            delay(2000)
        }
        return "TestCase"
    }
    suspend fun getAddress(): String {
        CoroutineScope(dispatcher).launch{
            delay(2000)
        }
        return "TestCase"
    }

    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher).launch{
            globalArg = true
        }
    }
}