package com.rafaelfelipeac.replyradar.features.reply.data

import com.rafaelfelipeac.replyradar.core.util.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.fakes.reply.data.FakeReplyDao
import com.rafaelfelipeac.replyradar.features.reply.data.database.entity.ReplyEntity
import com.rafaelfelipeac.replyradar.features.reply.data.repository.ReplyRepositoryImpl
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.util.valueOrEmpty
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class ReplyRepositoryTest {

    @Test
    fun `upsertReply should insert reply with correct timestamps when id is 0`() = runTest {
        val dao = FakeReplyDao()
        val repository = ReplyRepositoryImpl(dao)

        val reply = Reply(
            id = 0L,
            name = "George",
            subject = "Answer about the project"
        )

        val returnedId = repository.upsertReply(reply)

        assertEquals(1, dao.insertedReplies.size)

        assertEquals(1L, returnedId)
    }

    @Test
    fun `upsertReply should update reply with new updatedAt when id is not 0`() = runTest {
        val dao = FakeReplyDao()
        val repository = ReplyRepositoryImpl(dao)

        val reply = Reply(
            id = 42L,
            name = "John",
            subject = "Update data",
            createdAt = 1000L,
            updatedAt = 1000L
        )

        val returnedId = repository.upsertReply(reply)

        val inserted = dao.insertedReplies.first()
        assertEquals(42L, inserted.id)
        assertEquals(42L, returnedId)
    }

    @Test
    fun `toggleReplyResolve should toggle isResolved and set resolvedAt`() = runTest {
        val dao = FakeReplyDao()
        val repository = ReplyRepositoryImpl(dao)

        val reply = Reply(
            id = 1L,
            name = "Paul",
            subject = "Party",
            isArchived = true
        )

        repository.toggleReplyResolve(reply)

        val updated = dao.updatedReplies.first()
        assertEquals(true, updated.isResolved)
        assertEquals(true, updated.isArchived)
    }

    @Test
    fun `toggleReplyArchive should toggle isArchived and set archivedAt`() = runTest {
        val dao = FakeReplyDao()
        val repository = ReplyRepositoryImpl(dao)

        val reply = Reply(
            id = 2L,
            name = "Ringo",
            subject = "Lunch next week",
            isResolved = true
        )

        repository.toggleReplyArchive(reply)

        val updated = dao.updatedReplies.first()
        assertEquals(true, updated.isArchived)
        assertEquals(true, updated.isResolved)
    }

    @Test
    fun `deleteReply should call deleteReply on dao`() = runTest {
        val dao = FakeReplyDao()
        val repository = ReplyRepositoryImpl(dao)

        val reply = Reply(
            id = 10L,
            name = EMPTY,
            subject = EMPTY
        )

        repository.deleteReply(reply)

        assertEquals(listOf(10L), dao.deletedReplyIds)
    }

    @Test
    fun `getReplies should return resolved replies when isResolved is true`() = runTest {
        val replyEntities =
            listOf(ReplyEntity(id = 1L, name = "Resolved", subject = "R", isResolved = true))
        val dao = FakeReplyDao(resolved = replyEntities)
        val repository = ReplyRepositoryImpl(dao)

        val replies = repository.getReplies(isResolved = true, isArchived = false).valueOrEmpty()

        assertEquals(1, replies.size)
        assertEquals("Resolved", replies.first().name)
    }

    @Test
    fun `getReplies should return archived replies when isArchived is true`() = runTest {
        val replyEntities =
            listOf(ReplyEntity(id = 2L, name = "Archived", subject = "A", isArchived = true))
        val dao = FakeReplyDao(archived = replyEntities)
        val repository = ReplyRepositoryImpl(dao)

        val replies = repository.getReplies(isResolved = false, isArchived = true).valueOrEmpty()

        assertEquals(1, replies.size)
        assertEquals("Archived", replies.first().name)
    }

    @Test
    fun `getReplies should return active replies when none is true`() = runTest {
        val replyEntities = listOf(ReplyEntity(id = 3L, name = "Active", subject = "A"))
        val dao = FakeReplyDao(active = replyEntities)
        val repository = ReplyRepositoryImpl(dao)

        val replies = repository.getReplies(isResolved = false, isArchived = false).valueOrEmpty()

        assertEquals(1, replies.size)
        assertEquals("Active", replies.first().name)
    }
}
