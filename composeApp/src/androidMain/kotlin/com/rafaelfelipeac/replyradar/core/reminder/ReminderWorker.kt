package com.rafaelfelipeac.replyradar.core.reminder

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rafaelfelipeac.replyradar.R.string.reminder_name
import com.rafaelfelipeac.replyradar.R.string.reminder_reply_id
import com.rafaelfelipeac.replyradar.R.string.reminder_subject
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INVALID_ID

class ReminderWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val replyId = inputData.getLong(applicationContext.getString(reminder_reply_id), INVALID_ID)
        val name = inputData.getString(applicationContext.getString(reminder_name)) ?: return Result.failure()
        val subject = inputData.getString(applicationContext.getString(reminder_subject)) ?: return Result.failure()

        NotificationUtils.showReminderNotification(
            context = applicationContext,
            replyId = replyId,
            name = name,
            subject = subject
        )

        return Result.success()
    }
}
