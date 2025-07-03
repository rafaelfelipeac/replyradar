package com.rafaelfelipeac.replyradar.core.reminder

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_content
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_reply_id
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_tag
import com.rafaelfelipeac.replyradar.R.string.notification_reminder_title
import com.rafaelfelipeac.replyradar.core.reminder.model.NotificationReminderParams
import java.util.concurrent.TimeUnit.MILLISECONDS

private const val INVALID_DELAY = 0

class ReminderSchedulerImpl(
    private val context: Context
) : ReminderScheduler {

    override fun scheduleReminder(
        reminderAtMillis: Long,
        notificationReminderParams: NotificationReminderParams
    ) {
        val delay = getDelay(reminderAtMillis)

        if (delay <= INVALID_DELAY) return

        enqueueReminder(delay, notificationReminderParams)
    }

    override fun cancelReminder(replyId: Long) {
        WorkManager.getInstance(context).cancelAllWorkByTag(getTag(replyId))
    }

    private fun enqueueReminder(
        delay: Long,
        notificationReminderParams: NotificationReminderParams
    ) {
        with(notificationReminderParams) {
            val workRequest = OneTimeWorkRequestBuilder<ReminderWorker>()
                .setInitialDelay(delay, MILLISECONDS)
                .setInputData(
                    workDataOf(
                        context.getString(notification_reminder_reply_id) to replyId,
                        context.getString(notification_reminder_title) to notificationTitle,
                        context.getString(notification_reminder_content) to notificationContent
                    )
                )
                .addTag(getTag(replyId))
                .build()

            WorkManager.getInstance(context).enqueue(workRequest)
        }
    }

    private fun getDelay(reminderAtMillis: Long) = reminderAtMillis - System.currentTimeMillis()

    private fun getTag(replyId: Long) = context.getString(notification_reminder_tag, replyId)
}
