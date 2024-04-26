package com.testcase.junit_testcase.validPassword

//should not be empty
//length should between 6 & 15
//otherwise, return valid password

class Utils {

    fun validPassword(input: String) = when {
        input.isBlank() -> {
            "Password is requested field"
        }

        input.length < 6 -> {
            "Length of pass should be greater the 6"
        }

        input.length > 15 -> {
            "Length of pass should be less the 15"
        }

        else -> {
            "Valid"
        }
    }

    fun reverseString(input: String?) : String{
        if (input ==null){
            throw IllegalArgumentException("Input String is Required")
        }
        val char = input.toCharArray()
        var i=0
        var j = char.size-1
        while (i<j){
            val temp = char[i]
            char[i] = char[j]
            char[j] = temp
            i++
            j--
        }
        return char.joinToString("")
    }
}