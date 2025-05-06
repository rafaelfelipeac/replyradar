package com.rafaelfelipeac.replyradar.core.util.reminder

interface ReminderScheduler {
    fun scheduleReminder(
        reminderAtMillis: Long,
        name: String,
        subject: String,
        replyId: Long
    )

    fun cancelReminder(replyId: Long)
}
