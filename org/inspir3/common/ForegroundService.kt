package org.inspir3.common

import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE
import android.os.IBinder
import android.util.Log

/**
 * DO NOT EDIT
 * See android-lib project
 */
abstract class ForegroundService(
    private val icon: Int,
    private val title: String,
    private val content: String,
) : Service() {
    open fun onStart() {
        Log.e(I3.TAG, "ForegroundService.onStart() NOT IMPLEMENTED")
    }

    open fun onStop() {
        Log.e(I3.TAG, "ForegroundService.onClose() NOT IMPLEMENTED")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(I3.TAG, "ForegroundService.onStartCommand()")

        startForeground(
            1,
            NotificationHelper.createNotification(this, this.icon, this.title, this.content),
            FOREGROUND_SERVICE_TYPE_CONNECTED_DEVICE,
        )

        this.onStart()

        return START_STICKY //After an out enough memory, restart the service
    }

    override fun onDestroy() {
        Log.d(I3.TAG, "ForegroundService.onDestroy()")

        this.onStop()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
