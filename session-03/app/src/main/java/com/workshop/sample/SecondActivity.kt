package com.workshop.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.workshop.sample.MainActivity.Companion.MESSAGE_KEY
import com.workshop.sample.MainActivity.Companion.MY_RESULT_KEY

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val resultText = findViewById<TextView>(R.id.result)

        if (intent.extras != null) {
            val myResult = intent.extras.getInt(MY_RESULT_KEY)
            val message = intent.extras.getString(MESSAGE_KEY)
            resultText.text = "$message  \n $myResult"
        }

    }
}
