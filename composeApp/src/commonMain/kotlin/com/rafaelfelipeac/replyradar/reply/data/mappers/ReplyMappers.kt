package com.rafaelfelipeac.replyradar.reply.data.mappers

import com.rafaelfelipeac.replyradar.reply.data.database.ReplyEntity
import com.rafaelfelipeac.replyradar.reply.domain.Reply

fun Reply.toReplyEntity(): ReplyEntity {
    return ReplyEntity(
        id = id,
        title = title,
        description = description
    )
}

fun ReplyEntity.toReply(): Reply {
    return Reply(
        id = id,
        title = title,
        description = description,
    )
}