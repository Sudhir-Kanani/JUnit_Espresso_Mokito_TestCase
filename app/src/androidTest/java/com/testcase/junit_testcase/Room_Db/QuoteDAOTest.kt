package com.testcase.junit_testcase.Room_Db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class QuoteDAOTest {

    // use : add rule for architecture component to run task as synchronously, we try generate less thread for test case
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDAO: QuoteDAO

    @Before
    fun  setUp(){
        quoteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),QuoteDatabase::class.java
        ).allowMainThreadQueries().build()
        quoteDAO =  quoteDatabase.quoteDao()
    }

    @Test
    fun inputQuote_expectedSingleQuote() = runBlocking{
        val quote = RoomQuote(0,"This is Quote","Sk")
        quoteDAO.insertQuote(quote)

        //getOrAwaitValue() use for waiting for data updated
        val result = quoteDAO.getQuotes().getOrAwaitValue()

        Assert.assertEquals(1,result.size)
        Assert.assertEquals("This is Quote",result[0].text)
    }

    @Test
    fun deleteQuote_expectedNoResult() = runBlocking{
        val quote = RoomQuote(0,"This is Quote","Sk")
        quoteDAO.insertQuote(quote)

        quoteDAO.delete()

        val result = quoteDAO.getQuotes().getOrAwaitValue()

        Assert.assertEquals(0,result.size)
    }
    @After
    fun tearDown()
    {
        quoteDatabase.close()
    }
}