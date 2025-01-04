package com.android.roompractice

import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class MyService : Service() {
    @SuppressLint("ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flag: Int, startId: Int): Int {
        super.onStartCommand(intent, flag, startId)
        // Show a notification for the foreground service (this is required)
        val notification = NotificationCompat.Builder(this, "foreground_service_channel")
            .setContentTitle("Service Running")
            .setContentText("Opening your activity...")
            .setSmallIcon(R.drawable.ic_launcher_background) // Replace with your icon
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // Start the service in the foreground
        startForeground(1, notification)

        // Log for debugging purposes
        Log.d("TAG----->", "Foreground Service Started")

        // Start the activity from the service
        val activityIntent = Intent(this, NotificationScreen::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        startActivity(activityIntent)

        // Stop the foreground service after starting the activity
        stopForeground(true)
        stopSelf()

        return START_STICKY
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}