package com.workshop.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class LifecycleActivity : AppCompatActivity() {

    private var editText: EditText? = null
    private var statusTextView: TextView? = null
    private var checkbox: CheckBox? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        print("onCreate: ")

        println(savedInstanceState)

        editText = findViewById(R.id.editMessage)
        statusTextView = findViewById(R.id.textStatus)
        checkbox = findViewById(R.id.checkBox)

        findViewById<View>(R.id.submitButton).setOnClickListener {
            statusTextView?.text = editText?.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)

        outState?.putString(KEY_STATUS_TEXT, statusTextView?.text.toString())
        outState?.putBoolean(KEY_CHECKBOX_CHEECKED, checkbox?.isChecked == true)

        println("onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)

        println(savedInstanceState)

        statusTextView?.text = savedInstanceState?.getString(KEY_STATUS_TEXT)
        checkbox?.isChecked = savedInstanceState?.getBoolean(KEY_CHECKBOX_CHEECKED) == true

        println("onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    companion object {
        const val KEY_STATUS_TEXT = "status_text"
        const val KEY_CHECKBOX_CHEECKED = "checkbox_checked"
    }
}
