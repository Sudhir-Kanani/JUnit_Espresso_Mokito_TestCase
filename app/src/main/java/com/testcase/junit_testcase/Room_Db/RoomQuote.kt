package com.testcase.junit_testcase.Room_Db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomQuote(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String,
    val author : String
)