package com.testcase.junit_testcase.AddNotes_And_Show

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.testcase.junit_testcase.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val msg = intent.getStringExtra("KEY")
        findViewById<TextView>(R.id.txtMsg).text = msg
    }
}