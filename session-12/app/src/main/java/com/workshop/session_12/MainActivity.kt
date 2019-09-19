package com.workshop.session_12

import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.workshop.session_12.TimerService.Companion.KEY_ACTION_UPDATE_CURRENT_TIME
import com.workshop.session_12.TimerService.Companion.KEY_CURRENT

class MainActivity : AppCompatActivity() {

    val reciever = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {
            val currentTime = findViewById<TextView>(R.id.currentTimeText)
            currentTime.text = intent?.extras?.getLong(KEY_CURRENT).toTimeString()
        }

    }

    var service: TimerService? = null

    val serviceConnection = object : ServiceConnection {

        override fun onServiceDisconnected(name: ComponentName?) {
            println("disconnected from service")
            service = null
        }

        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            println("connected to service")
            service = (binder as TimerService.TimerServiceBinder).getTimerService()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentTime = findViewById<TextView>(R.id.currentTimeText)

        val intent = Intent(this, TimerService::class.java)

        findViewById<View>(R.id.startService).setOnClickListener {
            startService(intent)
        }
        findViewById<View>(R.id.stopService).setOnClickListener {
            stopService(intent)
        }
        findViewById<View>(R.id.bindService).setOnClickListener {
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }
        findViewById<View>(R.id.getCurrentTime).setOnClickListener {
            currentTime.text = service?.current?.toTimeString()
        }
        findViewById<View>(R.id.registerReciever).setOnClickListener {
        }
        findViewById<View>(R.id.startIntentService).setOnClickListener {
            val intent = Intent(this, DownloadService::class.java)
            startService(intent)
        }

    }

    override fun onResume() {
        super.onResume()

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(reciever, IntentFilter(KEY_ACTION_UPDATE_CURRENT_TIME))
    }

    override fun onStop() {
        super.onStop()

        LocalBroadcastManager.getInstance(this)
            .unregisterReceiver(reciever)
    }
}
