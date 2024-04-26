package com.testcase.junit_testcase.MVVM.Api

import com.testcase.prectice.Api.NewsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroClient {
    private var Instance: Retrofit? = null

    fun getInstance(): Retrofit {
        if (Instance == null) {
            synchronized(this) {
                Instance = Retrofit.Builder().baseUrl("https://newsdata.io/api/1/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            }
        }
        return Instance!!
    }


}