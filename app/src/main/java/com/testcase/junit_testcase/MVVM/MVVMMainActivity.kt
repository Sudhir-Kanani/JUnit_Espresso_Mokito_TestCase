package com.testcase.junit_testcase.MVVM

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testcase.junit_testcase.MVVM.ViewModel.NewsViewModelFactory
import com.testcase.junit_testcase.MyApplication
import com.testcase.junit_testcase.R
import com.testcase.prectice.Adapter.NewsAdapter
import com.testcase.prectice.Api.MyResponse
import com.testcase.prectice.ViewModel.NewsViewModel

class MVVMMainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.layoutManager = layoutManager

        val newsRepository = (application as MyApplication).newsRepository

        val newsViewModel = ViewModelProvider(
            this,
            NewsViewModelFactory(newsRepository)
        )[NewsViewModel::class.java]


        newsViewModel.getNews()

        newsViewModel.newsData.observe(this) { myResponse ->
            when (myResponse) {
                is MyResponse.Loading -> {

                }

                is MyResponse.Success -> {
                    Log.d("Response", "Response : ${myResponse.data?.get(0)?.title}")
                    recyclerView.adapter = NewsAdapter(myResponse.data!!)

                }

                is MyResponse.Error -> {
                    Log.d("Response", "Response : ${myResponse.exception?.toString()}")

                }
            }
        }

    }
}