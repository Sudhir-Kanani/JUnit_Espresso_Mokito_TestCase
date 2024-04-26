package com.testcase.junit_testcase.Quotify_Quote

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.testcase.junit_testcase.Quote

class QuotifyViewModel(private val context: Context) : ViewModel() {

    private var quotesList: Array<Quote> = emptyArray()
    private var index = 0
    init {
        quotesList = loadQuotesFromAssets()
    }

    private fun  loadQuotesFromAssets() : Array<Quote>{
       val inputStream =  context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer,Charsets.UTF_8)
        val gson = Gson()
       return gson.fromJson(json,Array<Quote>::class.java)
    }

    fun getQuote() = quotesList[index]

    fun nextQuote() = quotesList[++index % quotesList.size]

    fun  previousQuote() = quotesList[(--index  + quotesList.size) % quotesList.size ]
}