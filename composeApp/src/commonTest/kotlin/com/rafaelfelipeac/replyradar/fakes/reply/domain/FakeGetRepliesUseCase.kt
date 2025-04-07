package com.rafaelfelipeac.replyradar.fakes.reply.domain

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.domain.usecase.GetRepliesUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeGetRepliesUseCase : GetRepliesUseCase {

    var replies: List<Reply> = emptyList()
        set(value) {
            field = value
            repliesFlow.value = value
        }

    var resolvedReplies: List<Reply> = emptyList()
        set(value) {
            field = value
            resolvedRepliesFlow.value = value
        }

    var archivedReplies: List<Reply> = emptyList()
        set(value) {
            field = value
            archivedRepliesFlow.value = value
        }

    var shouldThrow = false

    private val repliesFlow = MutableStateFlow(replies)
    private val resolvedRepliesFlow = MutableStateFlow(resolvedReplies)
    private val archivedRepliesFlow = MutableStateFlow(archivedReplies)

    override suspend fun getReplies(
        isResolved: Boolean,
        isArchived: Boolean
    ): Flow<List<Reply>> {
        if (shouldThrow) throw RuntimeException("Fake error.")

        return when {
            isResolved -> resolvedRepliesFlow
            isArchived -> archivedRepliesFlow
            else -> repliesFlow
        }
    }
}

