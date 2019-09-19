package com.workshop.session_12

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class TimerService : Service() {

    var started: Long? = null
    var stopped: Long? = null
    var current: Long? = null

    var binder: TimerServiceBinder? = null

    var running = true

    val timer = Thread {
        while (running) {
            current = System.currentTimeMillis()
            println(current.toTimeString())

            val intent = Intent().apply {
                action = KEY_ACTION_UPDATE_CURRENT_TIME
                putExtra(KEY_CURRENT, current!!)
            }
            LocalBroadcastManager.getInstance(baseContext)
                .sendBroadcast(intent)

            val channel = NotificationChannel("default", "My Default", NotificationCompat.PRIORITY_DEFAULT)
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)

            val notification = NotificationCompat.Builder(baseContext, "default")
                .setContentTitle("Timer")
                .setContentText(current.toTimeString())
                .build()

            startForeground(1, notification)

            Thread.sleep(1000)
        }
    }

    override fun onUnbind(intent: Intent?): Boolean {
        println("onUnbind " + Thread.currentThread().name)
        return super.onUnbind(intent)
    }

    override fun onCreate() {
        super.onCreate()
        binder = TimerServiceBinder()
        timer.start()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        started = System.currentTimeMillis()

        println("onStartCommand " + Thread.currentThread().name)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        println("onDestroy " + Thread.currentThread().name)
        running = false
        stopped = System.currentTimeMillis()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        println("onBind " + Thread.currentThread().name)
        return binder
    }

    inner class TimerServiceBinder : Binder() {
        fun getTimerService() = this@TimerService
    }

    companion object {
        const val KEY_CURRENT = "current"
        const val KEY_ACTION_UPDATE_CURRENT_TIME = "UPDATE_CURRENT_TIME"
    }
}