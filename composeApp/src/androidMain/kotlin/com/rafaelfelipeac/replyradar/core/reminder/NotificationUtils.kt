package com.rafaelfelipeac.replyradar.core.reminder

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_IMMUTABLE
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_HIGH
import androidx.core.app.NotificationManagerCompat
import com.rafaelfelipeac.replyradar.MainActivity
import com.rafaelfelipeac.replyradar.R
import com.rafaelfelipeac.replyradar.R.string.notification_channel_id
import com.rafaelfelipeac.replyradar.core.util.AppConstants.PENDING_REPLY_ID_KEY

object NotificationUtils {

    fun showReminderNotification(
        context: Context,
        replyId: Long,
        notificationTitle: String,
        notificationContent: String
    ) {
        val notification = NotificationCompat.Builder(
            context,
            context.getString(notification_channel_id)
        )
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle(notificationTitle)
            .setContentText(notificationContent)
            .setPriority(PRIORITY_HIGH)
            .setContentIntent(getPendingIntent(context = context, replyId = replyId))
            .setAutoCancel(true)
            .build()

        if (ActivityCompat.checkSelfPermission(context, POST_NOTIFICATIONS) != PERMISSION_GRANTED) {
            return
        }

        NotificationManagerCompat.from(context).notify(replyId.hashCode(), notification)
    }

    private fun getPendingIntent(context: Context, replyId: Long): PendingIntent? {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = FLAG_ACTIVITY_NEW_TASK or FLAG_ACTIVITY_CLEAR_TASK
            putExtra(PENDING_REPLY_ID_KEY, replyId)
        }

        return PendingIntent.getActivity(
            context,
            replyId.hashCode(),
            intent,
            FLAG_UPDATE_CURRENT or FLAG_IMMUTABLE
        )
    }
}
