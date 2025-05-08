package com.rafaelfelipeac.replyradar.core.util.reminder

import android.Manifest.permission.POST_NOTIFICATIONS
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_HIGH
import androidx.core.app.NotificationManagerCompat
import com.rafaelfelipeac.replyradar.R
import com.rafaelfelipeac.replyradar.R.string.notification_channel_id
import com.rafaelfelipeac.replyradar.R.string.notification_content_reminder_title

object NotificationUtils {
    fun showReminderNotification(context: Context, name: String, subject: String) {
        val notification = NotificationCompat.Builder(
            context,
            context.getString(notification_channel_id)
        )
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(context.getString(notification_content_reminder_title, name))
            .setContentText(subject)
            .setPriority(PRIORITY_HIGH)
            .build()

        if (ActivityCompat.checkSelfPermission(
                context,
                POST_NOTIFICATIONS
            ) != PERMISSION_GRANTED
        ) {
            return
        }

        NotificationManagerCompat.from(context).notify(name.hashCode(), notification)
    }
}
