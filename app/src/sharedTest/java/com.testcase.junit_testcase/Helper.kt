package com.testcase.junit_testcase

import java.io.InputStream
import java.io.InputStreamReader

object Helper {
    fun readFromResource(fulename:String):String{
        val inputStream = Helper::class.java.getResourceAsStream(fulename)
        val builder = StringBuilder()
        val read = InputStreamReader(inputStream,"UTF-8")
        read.readLines().forEach {
            builder.append(it)
        }
        return  builder.toString()
    }
}