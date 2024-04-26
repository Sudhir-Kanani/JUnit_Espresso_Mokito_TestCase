package com.testcase.junit_testcase.Room_Db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RoomQuote::class], version = 1)
abstract class QuoteDatabase  : RoomDatabase(){
     abstract fun quoteDao(): QuoteDAO
}