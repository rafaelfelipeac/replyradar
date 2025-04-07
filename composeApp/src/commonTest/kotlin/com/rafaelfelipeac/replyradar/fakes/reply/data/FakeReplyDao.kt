package com.rafaelfelipeac.replyradar.fakes.reply.data

import com.rafaelfelipeac.replyradar.features.reply.data.database.dao.ReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import kotlinx.coroutines.flow.flowOf

class FakeReplyDao(
    private val active: List<ReplyEntity> = emptyList(),
    private val resolved: List<ReplyEntity> = emptyList(),
    private val archived: List<ReplyEntity> = emptyList()
) : ReplyDao {

    val insertedReplies = mutableListOf<ReplyEntity>()
    val updatedReplies = mutableListOf<ReplyEntity>()
    val deletedReplyIds = mutableListOf<Long>()

    override suspend fun insert(reply: ReplyEntity): Long {
        insertedReplies += reply
        return reply.id.takeIf { it != 0L } ?: 1L
    }

    override suspend fun update(reply: ReplyEntity): Int {
        updatedReplies += reply

        return 1
    }

    override suspend fun deleteReply(id: Long) {
        deletedReplyIds += id
    }

    override fun getReply(id: Long): ReplyEntity? {
        return (active + resolved + archived + insertedReplies).find { it.id == id }
    }

    override fun getResolvedReplies() = flowOf(resolved)

    override fun getArchivedReplies() = flowOf(archived)

    override fun getActiveReplies() = flowOf(active)

    fun setReplyName(id: Long, name: String) {
        insertedReplies.removeAll { it.id == id }
        insertedReplies += ReplyEntity(
            id = id,
            name = name,
            subject = "",
            isResolved = false,
            isArchived = false,
            createdAt = 0L
        )
    }
}
