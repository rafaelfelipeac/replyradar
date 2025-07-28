package com.rafaelfelipeac.replyradar.features.reply.data.mapper

import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

fun Reply.toReplyEntity() = ReplyEntity(
    id = id,
    name = name,
    subject = subject,
    isResolved = isResolved,
    isArchived = isArchived,
    createdAt = createdAt,
    updatedAt = updatedAt,
    resolvedAt = resolvedAt,
    archivedAt = archivedAt,
    reminderAt = reminderAt
)

fun ReplyEntity.toReply() = Reply(
    id = id,
    name = name,
    subject = subject,
    isResolved = isResolved,
    isArchived = isArchived,
    createdAt = createdAt,
    updatedAt = updatedAt,
    resolvedAt = resolvedAt,
    archivedAt = archivedAt,
    reminderAt = reminderAt
)
