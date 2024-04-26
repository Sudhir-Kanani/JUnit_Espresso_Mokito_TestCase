package com.testcase.junit_testcase

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)          //Assert
    fun popularQuoteFormAssets() {
        //  Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.popularQuoteFormAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)          //Assert
    fun popularQuoteFormAssets_invalidJson_expected_Exception() {
        //  Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.popularQuoteFormAssets(context, "malformed.json")
    }

    @Test
    fun popularQuoteFormAssets_validJson_expected_Count() {
        //  Arrange
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        //Act
        quoteManager.popularQuoteFormAssets(context, "quotes.json")
        //Assert
        assertEquals(1643, quoteManager.quotesList.size)
    }

    @Test
    fun testPreviousQuote_expected_correctQuote() {
        //arrange
        val quoteManager = QuoteManager()
        quoteManager.popularQuotes(
            arrayOf(
                Quote("this is first quote", "1"),
                Quote("this is second quote", "2"),
                Quote("this is third quote", "3")
            )
        )
        ///act
        val quote = quoteManager.getPreviousQuote()
        //assert
        assertEquals("1", quote.author)
    }

    @Test
    fun testNextQuote_expected_correctQuote() {
        val quoteManager = QuoteManager()
        quoteManager.popularQuotes(
            arrayOf(
                Quote("this is first quote", "1"),
                Quote("this is second quote", "2"),
                Quote("this is third quote", "3")
            )
        )
        val quote = quoteManager.getNextQuote()
        assertEquals("2", quote.author)
    }
}