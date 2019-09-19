package com.workshop.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1Edit = findViewById<EditText>(R.id.number1EditText)
        val number2Edit = findViewById<EditText>(R.id.number2EditText)
        val resultView = findViewById<TextView>(R.id.resultText)
        val addButton = findViewById<TextView>(R.id.addButton)

        addButton.setOnClickListener {
            val number1: Int = number1Edit.text.toString().toInt()
            val number2: Int = number2Edit.text.toString().toInt()

            val result = number1 + number2

            resultView.text = result.toString()
        }

    }
}
