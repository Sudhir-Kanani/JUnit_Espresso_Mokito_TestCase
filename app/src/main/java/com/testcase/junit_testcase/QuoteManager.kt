package com.testcase.junit_testcase

import android.content.Context
import com.google.gson.Gson




class QuoteManager {

    var quotesList = emptyArray<Quote>()
    var currentQuoteCount = 0

    fun popularQuoteFormAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quotesList = gson.fromJson(json, Array<Quote>::class.java)
    }


    fun popularTESTAssets(context: Context, fileName: String) {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        quotesList = gson.fromJson(json, Array<Quote>::class.java)
    }

    fun popularQuotes(quotes: Array<Quote>) {
        quotesList = quotes
    }

    fun getCurrentQuotes(): Quote {
        return quotesList[currentQuoteCount]
    }

    fun getNextQuote(): Quote {
        return if (currentQuoteCount == quotesList.size - 1) quotesList[currentQuoteCount] else quotesList[++currentQuoteCount]
    }

    fun getPreviousQuote(): Quote {
        return if (currentQuoteCount == 0) quotesList[currentQuoteCount] else quotesList[--currentQuoteCount]
    }
}