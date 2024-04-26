package com.testcase.junit_testcase

import android.content.Context
import android.content.res.AssetManager
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn

class QuoteManagerTest {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager : AssetManager

    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
    }
    @Test
    fun test(){

            // when call context.assets return assetManager
        doReturn(assetManager).`when`(context).assets


        val testStream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream)

        val sut = QuoteManager()
        sut.popularQuoteFormAssets(context,"")
        val quotes = sut.getCurrentQuotes()

        Assert.assertEquals("Genius is one percent inspiration and ninety-nine percent perspiration.",quotes.text)
    }

}