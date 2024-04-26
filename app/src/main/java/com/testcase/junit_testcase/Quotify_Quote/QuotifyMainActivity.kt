package com.testcase.junit_testcase.Quotify_Quote

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.testcase.junit_testcase.Quote
import com.testcase.junit_testcase.R

class QuotifyMainActivity : AppCompatActivity() {
    lateinit var viewModel: QuotifyViewModel

    private val quoteText: TextView
        get() = findViewById(R.id.quoteText)

    private val quoteAuthor: TextView
        get() = findViewById(R.id.quoteAuthor)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotify_main)


        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                QuotifyViewModel(applicationContext)
            }
        }

        viewModel = ViewModelProvider(this, factory).get(QuotifyViewModel::class.java)
        setQuote(viewModel.getQuote())
    }

    fun setQuote(quote: Quote) {
        quoteText.text = quote.text
        quoteAuthor.text = quote.author
    }
    fun onPrevious(view: View) {
        setQuote(viewModel.previousQuote())
    }

    fun onNext(view: View) {
        setQuote(viewModel.nextQuote())
    }

    fun onShare(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, viewModel.getQuote().text)
        startActivity(intent)
    }
}