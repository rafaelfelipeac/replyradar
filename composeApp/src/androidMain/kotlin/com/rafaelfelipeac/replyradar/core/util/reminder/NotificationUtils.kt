package com.rafaelfelipeac.replyradar.core.util.reminder

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.rafaelfelipeac.replyradar.R

object NotificationUtils {
    fun showReminderNotification(context: Context, name: String, subject: String) {
        val notification = NotificationCompat.Builder(context, "reminder_channel")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Reminder: $name")
            .setContentText(subject)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        NotificationManagerCompat.from(context).notify(name.hashCode(), notification)
    }
}
