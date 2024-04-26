package com.testcase.junit_testcase.AddNotes_And_Show

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.testcase.junit_testcase.R

class AddNotes_And_ShowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes_and_show)

        val edtTitle = findViewById<EditText>(R.id.edtTitle)
        val edtdes = findViewById<EditText>(R.id.edtdes)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val msg = "Title - ${edtTitle.text} | Desc - ${edtdes.text}"
            val intent = Intent(this@AddNotes_And_ShowActivity,SecondActivity::class.java)
            intent.putExtra("KEY",msg)
            startActivity(intent)
        }
    }
}