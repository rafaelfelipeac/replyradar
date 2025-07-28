package com.rafaelfelipeac.replyradar.core.reminder

import com.rafaelfelipeac.replyradar.core.reminder.model.NotificationReminderParams

interface ReminderScheduler {

    fun scheduleReminder(
        reminderAtMillis: Long,
        notificationReminderParams: NotificationReminderParams
    )

    fun cancelReminder(replyId: Long)
}
