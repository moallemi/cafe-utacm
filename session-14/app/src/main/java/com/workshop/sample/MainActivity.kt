package com.workshop.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.workshop.sample.kotlin.Student2
import com.workshop.sample.kotlin.Student3

class MainActivity : AppCompatActivity() {

    companion object {
        const val MY_RESULT_KEY = "RESULT"
        const val MESSAGE_KEY = "MESSAGE"
        const val KEY_STUDENT = "STUDENT"
    }

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

            val student = Student2("Ali", "Ahmadni", 12)

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(MY_RESULT_KEY, result)
                putExtra(MESSAGE_KEY, "This is result")
                putExtra(KEY_STUDENT, student)
                putExtra("", Student3("","", 12))
            }
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.nextScreenButton)
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}
