package com.testcase.junit_testcase.utils

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class HelperTest {
    private lateinit var helper:Helper
    @Before
    fun setUp(){
        helper = Helper()
        println("Before Every Test Case")
    }

    @After
    fun tearDown(){
        println("After Every Test Case")
    }

    @Test
    fun isPalindrome() {
        //arrange
//        val helper = Helper()

        //act
        val result = helper.isPalindrome("hello")

        //Assert
        assertEquals(false,result)
    }

    @Test
    fun isPalindrome_inputSting_level_expectedTrue() {
        //arrange
//        val helper = Helper()

        //act
        val result = helper.isPalindrome("level")

        //Assert
        assertEquals(true,result)
    }
}