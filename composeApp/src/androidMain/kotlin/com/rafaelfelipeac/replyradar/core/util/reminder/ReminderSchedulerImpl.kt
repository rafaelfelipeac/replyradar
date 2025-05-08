package com.rafaelfelipeac.replyradar.core.util.reminder

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.rafaelfelipeac.replyradar.R.string.reminder_name
import com.rafaelfelipeac.replyradar.R.string.reminder_reply_id
import com.rafaelfelipeac.replyradar.R.string.reminder_subject
import com.rafaelfelipeac.replyradar.R.string.reminder_tag
import java.util.concurrent.TimeUnit

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
        val delay = reminderAtMillis - System.currentTimeMillis()
        if (delay <= INVALID_DELAY) return

        enqueueReminder(delay, name, subject, replyId)
    }

    private fun enqueueReminder(delay: Long, name: String, subject: String, replyId: Long) {
        val workRequest = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .setInputData(
                workDataOf(
                    context.getString(reminder_name) to name,
                    context.getString(reminder_subject) to subject,
                    context.getString(reminder_reply_id) to replyId.toString()
                )
            )
            .addTag(getTag(replyId))
            .build()

        WorkManager.getInstance(context).enqueue(workRequest)
    }

    override fun cancelReminder(replyId: Long) {
        WorkManager.getInstance(context).cancelAllWorkByTag(getTag(replyId))
    }

    private fun getTag(replyId: Long) = context.getString(reminder_tag, replyId)
}
