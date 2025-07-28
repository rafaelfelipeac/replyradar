package com.rafaelfelipeac.replyradar.fakes.core.util

import com.rafaelfelipeac.replyradar.core.reminder.ReminderScheduler
import com.rafaelfelipeac.replyradar.core.reminder.model.NotificationReminderParams

class FakeReminderScheduler : ReminderScheduler {

    private val scheduledReminders = mutableListOf<Pair<Long, NotificationReminderParams>>()
    private val cancelledReminders = mutableListOf<Long>()

    override fun scheduleReminder(
        reminderAtMillis: Long,
        notificationReminderParams: NotificationReminderParams
    ) {
        scheduledReminders.add(reminderAtMillis to notificationReminderParams)
    }

    override fun cancelReminder(replyId: Long) {
        cancelledReminders.add(replyId)
    }
}
