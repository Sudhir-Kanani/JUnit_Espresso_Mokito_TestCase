package com.testcase.junit_testcase.utils

import com.testcase.junit_testcase.validPassword.Utils
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

class reverseStringTest {
    @Test
    fun testStringReversel_EmptyString_expected_EmptySting(){
        val sut = Utils()
        val result = sut.reverseString("")
        assertEquals("",result)
    }

    @Test
    fun testStringReversel_singleChar_expected_singleChar(){
        val sut = Utils()
        val result = sut.reverseString("a")
        assertEquals("a",result)
    }

    @Test
    fun testStringReversel_validInput_expected_sameString(){
        val sut = Utils()
        val result = sut.reverseString("helloWorld")
        assertEquals("dlroWolleh",result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversel_nullValue_expected_Exception(){
        val sut = Utils()
        sut.reverseString(null)
    }
}

@RunWith(value = Parameterized::class)
class reverseStringParameterized(private val input:String,private val expected:String){
    @Test
    fun test(){
        val sut = Utils()
        val result = sut.reverseString(input)
        assertEquals(expected,result)
    }
    companion object{
        @JvmStatic
        @Parameters(name = "{index} - {0}- output - {1}")
        fun data():List<Array<Any>>{
            return  listOf(
                arrayOf("",""),
                arrayOf("a","a"),
                arrayOf("helloWorld","dlroWolleh"),
            )
        }
    }
}