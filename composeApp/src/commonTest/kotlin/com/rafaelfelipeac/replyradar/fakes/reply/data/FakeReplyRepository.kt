package com.rafaelfelipeac.replyradar.fakes.reply.data

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.repository.ReplyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeReplyRepository : ReplyRepository {

    val upsertedReplies = mutableListOf<Reply>()
    val deletedReplies = mutableListOf<Reply>()
    val archivedToggledReplies = mutableListOf<Reply>()
    val resolvedToggledReplies = mutableListOf<Reply>()

    var insertedReplyId: Long = 1L

    var repliesToReturn: Flow<List<Reply>> = flowOf(emptyList())

    var receivedIsResolved: Boolean? = null
    var receivedIsArchived: Boolean? = null

    override suspend fun deleteReply(reply: Reply) {
        deletedReplies += reply
    }

    override suspend fun toggleReplyArchive(reply: Reply) {
        archivedToggledReplies += reply
    }

    override suspend fun toggleReplyResolve(reply: Reply) {
        resolvedToggledReplies += reply
    }

    override suspend fun upsertReply(reply: Reply): Long {
        upsertedReplies += reply

        return insertedReplyId
    }

    override suspend fun getReplies(isResolved: Boolean, isArchived: Boolean): Flow<List<Reply>> {
        receivedIsResolved = isResolved
        receivedIsArchived = isArchived
        return repliesToReturn
    }
}
