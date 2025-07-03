package com.rafaelfelipeac.replyradar.core.reminder.model

data class NotificationReminderParams(
    val replyId: Long,
    val notificationTitle: String,
    val notificationContent: String
)
