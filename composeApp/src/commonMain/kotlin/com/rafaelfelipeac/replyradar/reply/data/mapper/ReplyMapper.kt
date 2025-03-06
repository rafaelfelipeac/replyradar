package com.rafaelfelipeac.replyradar.reply.data.mapper

import com.rafaelfelipeac.replyradar.reply.data.database.entity.ReplyEntity
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply

fun Reply.toReplyEntity(): ReplyEntity {
    return ReplyEntity(
        id = id,
        name = name,
        subject = subject,
        isResolved = isResolved
    )
}

fun ReplyEntity.toReply(): Reply {
    return Reply(
        id = id,
        name = name,
        subject = subject,
        isResolved = isResolved
    )
}