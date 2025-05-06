package com.rafaelfelipeac.replyradar.core.util.reminder

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit

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
        if (delay <= 0) return

        enqueueReminder(delay, name, subject, replyId)
    }

    private fun enqueueReminder(delay: Long, name: String, subject: String, replyId: Long) {
        val workRequest = OneTimeWorkRequestBuilder<ReminderWorker>()
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .setInputData(
                workDataOf(
                    "name" to name,
                    "subject" to subject,
                    "replyId" to replyId.toString()
                )
            )
            .addTag("reminder-$replyId")
            .build()

        WorkManager.getInstance(context).enqueue(workRequest)
    }

    override fun cancelReminder(replyId: Long) {
        WorkManager.getInstance(context).cancelAllWorkByTag("reminder-$replyId")
    }
}
