package com.workshop.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_network.*
import java.net.URL

class NetworkActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        println("0) ${Thread.currentThread().name}")

        loadButton.setOnClickListener {
            println("1) ${Thread.currentThread().name}")

            Thread {
                println("2) ${Thread.currentThread().name}")
                val result = loadDataFromServer()
                println("3) ${Thread.currentThread().name}")

                runOnUiThread {
                    Toast.makeText(this, result, Toast.LENGTH_LONG).show()
                }
            }.start()
            println("4) ${Thread.currentThread().name}")
        }
    }

    private fun loadDataFromServer(): String {
        val url = "https://restapis.xyz/around-me/v1/featured"
        return URL(url)
            .openStream()
            .bufferedReader()
            .use {
                it.readText()
            }
    }
}
