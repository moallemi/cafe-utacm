package com.workshop.session_12

import android.app.IntentService
import android.content.Intent

class DownloadService : IntentService("DownloadService") {

    override fun onCreate() {
        super.onCreate()
        println("onCreate " + Thread.currentThread().name)
    }

    override fun onHandleIntent(intent: Intent?) {
        println("onHandleIntent ${System.currentTimeMillis().toTimeString()}" + Thread.currentThread().name)
        Thread.sleep(5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy " + Thread.currentThread().name)
    }

}