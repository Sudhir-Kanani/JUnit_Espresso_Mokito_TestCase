package com.testcase.junit_testcase.Room_Db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.testcase.junit_testcase.Quote

@Dao
interface QuoteDAO {
    @Insert
    suspend fun insertQuote(roomQuote: RoomQuote)

    @Update
    suspend fun updateQuote(roomQuote: RoomQuote)

    @Query("DELETE FROM roomquote")
    suspend fun delete()

    @Query("SELECT * FROM roomquote")
     fun getQuotes():LiveData<List<RoomQuote>>

    @Query("SELECT * FROM roomquote WHERE id = :quoteId")
    suspend fun getQuoteById(quoteId : Int):RoomQuote

}