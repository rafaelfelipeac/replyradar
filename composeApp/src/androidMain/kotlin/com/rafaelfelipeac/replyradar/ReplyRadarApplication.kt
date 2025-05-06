package com.rafaelfelipeac.replyradar

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.rafaelfelipeac.replyradar.di.initKoin
import org.koin.android.ext.koin.androidContext

class ReplyRadarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        initKoin {
            androidContext(this@ReplyRadarApplication)
        }

        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "reminder_channel"
            val name = "Reminder Notifications"
            val descriptionText = "Notifications for scheduled reminders"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {
        lateinit var instance: ReplyRadarApplication
            private set
    }
}
