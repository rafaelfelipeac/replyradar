package com.rafaelfelipeac.replyradar.features.reply.data.mapper

import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

fun Reply.toReplyEntity() = ReplyEntity(
    id = id,
    name = name,
    subject = subject,
    isResolved = isResolved,
    createdAt = createdAt,
    updatedAt = updatedAt,
    resolvedAt = resolvedAt
)


fun ReplyEntity.toReply() = Reply(
    id = id,
    name = name,
    subject = subject,
    isResolved = isResolved,
    createdAt = createdAt,
    updatedAt = updatedAt,
    resolvedAt = resolvedAt
)
