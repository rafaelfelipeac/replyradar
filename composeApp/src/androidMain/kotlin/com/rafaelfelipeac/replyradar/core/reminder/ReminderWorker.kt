package com.rafaelfelipeac.replyradar.core.reminder

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_content
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_reply_id
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_title
import com.rafaelfelipeac.replyradar.core.reminder.NotificationUtils.showReminderNotification
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INVALID_ID

class ReminderWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val replyId = inputData.getLong(
            applicationContext.getString(notification_reminder_reply_id),
            INVALID_ID
        )

        if (replyId == INVALID_ID) {
            return Result.failure()
        }

        val notificationTitle =
            inputData.getString(applicationContext.getString(notification_reminder_title))
                ?: return Result.failure()
        val notificationContent =
            inputData.getString(applicationContext.getString(notification_reminder_content))
                ?: return Result.failure()

        showReminderNotification(
            context = applicationContext,
            replyId = replyId,
            notificationTitle = notificationTitle,
            notificationContent = notificationContent
        )

        return Result.success()
    }
}
