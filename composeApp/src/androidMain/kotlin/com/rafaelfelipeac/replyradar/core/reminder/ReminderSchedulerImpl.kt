package com.rafaelfelipeac.replyradar.core.reminder

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.rafaelfelipeac.replyradar.R.string.reminder_name
import com.rafaelfelipeac.replyradar.R.string.reminder_reply_id
import com.rafaelfelipeac.replyradar.R.string.reminder_subject
import com.rafaelfelipeac.replyradar.R.string.reminder_tag
import java.util.concurrent.TimeUnit.MILLISECONDS

private const val INVALID_DELAY = 0

class ReminderSchedulerImpl(
    private val context: Context
) : ReminderScheduler {

    override fun scheduleReminder(
        reminderAtMillis: Long,
        name: String,
        subject: String,
        replyId: Long
    ) {
        val delay = getDelay(reminderAtMillis)

        if (delay <= INVALID_DELAY) return

        enqueueReminder(delay, name, subject, replyId)
    }

    override fun cancelReminder(replyId: Long) {
        WorkManager.getInstance(context).cancelAllWorkByTag(getTag(replyId))
    }

    private fun enqueueReminder(delay: Long, name: String, subject: String, replyId: Long) {
        val workRequest = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInitialDelay(delay, MILLISECONDS)
            .setInputData(
                workDataOf(
                    context.getString(reminder_reply_id) to replyId,
                    context.getString(reminder_name) to name,
                    context.getString(reminder_subject) to subject,
                )
            )
            .addTag(getTag(replyId))
            .build()

        WorkManager.getInstance(context).enqueue(workRequest)
    }

    private fun getDelay(reminderAtMillis: Long) = reminderAtMillis - System.currentTimeMillis()

    private fun getTag(replyId: Long) = context.getString(reminder_tag, replyId)
}
