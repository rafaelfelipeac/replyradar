package com.rafaelfelipeac.replyradar.core.reminder

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.rafaelfelipeac.replyradar.R.string.reminder_name
import com.rafaelfelipeac.replyradar.R.string.reminder_subject

class ReminderWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {//
        val name = inputData.getString(applicationContext.getString(reminder_name)) ?: return Result.failure()
        val subject = inputData.getString(applicationContext.getString(reminder_subject)) ?: return Result.failure()

        NotificationUtils.showReminderNotification(applicationContext, name, subject)

        return Result.success()
    }
}
