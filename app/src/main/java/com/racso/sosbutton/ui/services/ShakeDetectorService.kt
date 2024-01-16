package com.racso.sosbutton.ui.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.racso.sosbutton.R
import kotlin.math.sqrt

class ShakeDetectionService : Service(), SensorEventListener {

    private val CHANNEL_ID = "ShakeDetectionServiceChannel"
    private val SHAKE_THRESHOLD = 800 // Adjust this value based on your requirements

    private lateinit var sensorManager: SensorManager

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        startForegroundService()
        initializeSensor()
    }

    override fun onDestroy() {
        super.onDestroy()
        stopSensor()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val serviceChannel = NotificationChannel(
                CHANNEL_ID,
                "Shake Detection Service Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(serviceChannel)
        }
    }

    private fun startForegroundService() {
        val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Shake Detection Service")
            .setContentText("Service is running in the background")
            .setSmallIcon(R.drawable.img)
            .build()

        startForeground(1, notification)
    }

    private fun initializeSensor() {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    private fun stopSensor() {
        sensorManager.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // Not needed for accelerometer
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            val acceleration = sqrt(x * x + y * y + z * z)
            if (acceleration > SHAKE_THRESHOLD) {
                // Shake detected, implement your logic here
                Toast.makeText(this,"Shake detected!!!", Toast.LENGTH_SHORT).show()
                Log.i("ShakeDetectionService","Shake detected!!!")
            }
        }
    }
}