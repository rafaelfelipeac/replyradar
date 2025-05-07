package com.rafaelfelipeac.replyradar

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_HIGH
import android.os.Build
import com.rafaelfelipeac.replyradar.R.string.notification_channel_id
import com.rafaelfelipeac.replyradar.R.string.notification_channel_name
import com.rafaelfelipeac.replyradar.R.string.notifications_channel_description
import com.rafaelfelipeac.replyradar.di.initKoin
import org.koin.android.ext.koin.androidContext

class ReplyRadarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        initKoin {
            androidContext(this@ReplyRadarApplication)
        }

        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val id = getString(notification_channel_id)
            val name = getString(notification_channel_name)
            val descriptionText = getString(notifications_channel_description)
            val importance = IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).apply {
                description = descriptionText
            }
            val notificationManager = getSystemService(NotificationManager::class.java)

            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        lateinit var instance: ReplyRadarApplication
            private set
    }
}
