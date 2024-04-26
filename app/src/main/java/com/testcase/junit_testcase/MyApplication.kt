package com.testcase.junit_testcase

import android.app.Application
import com.testcase.junit_testcase.MVVM.Api.RetroClient
import com.testcase.prectice.Api.NewsApi
import com.testcase.prectice.ViewModel.NewsRepository

class MyApplication : Application() {
    lateinit var newsRepository:NewsRepository

    override fun onCreate() {
        super.onCreate()
        init()
    }
    private fun init() {

        val quotesApi = RetroClient().getInstance().create(NewsApi::class.java)
         newsRepository = NewsRepository(quotesApi)

    }
}