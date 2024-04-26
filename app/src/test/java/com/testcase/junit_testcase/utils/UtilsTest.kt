package com.testcase.junit_testcase.utils

import com.testcase.junit_testcase.validPassword.Utils
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters

class UtilsTest {
    @Test
    fun validPass_blankInput_expected_requiredField() {
        val sut = Utils()
        val result = sut.validPassword("    ")
        assertEquals("Password is requested field", result)
    }

    @Test
    fun validPass_2CharInput_expected_validationMsg() {
        val sut = Utils()
        val result = sut.validPassword("ab")
        assertEquals("Length of pass should be greater the 6", result)
    }

    @Test
    fun validPass_correctInput_expected_validPass() {
        val sut = Utils()
        val result = sut.validPassword("abcd123")
        assertEquals("Valid", result)
    }


}

@RunWith(value = Parameterized::class)
class ParameterizedTest(private val input: String, private val expected: String) {
    @Test
    fun test() {
        val sut = Utils()
        val result = sut.validPassword(input)
        assertEquals(expected, result)
    }

    companion object {
        @JvmStatic
        @Parameters(name = "{index} - {0} - {1}")
        fun data(): List<Array<Any>> {
            return listOf(
                arrayOf("  ", "Password is requested field"),
                arrayOf("ab", "Length of pass should be greater the 6"),
                arrayOf("abcdefg1234567890", "Length of pass should be less the 15"),
                arrayOf("abcd123", "Valid")
            )
        }
    }

}