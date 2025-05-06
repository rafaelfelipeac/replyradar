package com.rafaelfelipeac.replyradar.core.util.reminder

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class ReminderWorker(
    appContext: Context,
    workerParams: WorkerParameters
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        val name = inputData.getString("name") ?: return Result.failure()
        val subject = inputData.getString("subject") ?: return Result.failure()

        NotificationUtils.showReminderNotification(applicationContext, name, subject)

        return Result.success()
    }
}
