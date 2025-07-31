package com.rafaelfelipeac.replyradar.previews

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply

sealed class Replies {

    data object OnTheRadar : Replies() {
        val reply1 = Reply(
            id = 1,
            name = "Lucas Almeida",
            subject = "Wanna grab coffee sometime?",
            createdAt = 1741120800000L
        )
        val reply2 = Reply(
            id = 2,
            name = "Sofia Ribeiro",
            subject = "Update on Monday's project"
        )
        val reply3 = Reply(
            id = 3,
            name = "Thiago Martins",
            subject = "Did you get a chance to check the contract?"
        )
        val reply4 = Reply(
            id = 4,
            name = "Marina Costa",
            subject = "You're invited to my birthday 🎉"
        )
        val reply5 = Reply(
            id = 5,
            name = "Diego Fernandes",
            subject = "Meeting moved to Friday, okay?"
        )

        val replies = listOf(reply1, reply2, reply3, reply4, reply5)
    }

    data object Resolved : Replies() {
        val reply1 = Reply(
            id = 1,
            name = "Lucas Almeida",
            subject = "Wanna grab coffee sometime?",
            isResolved = true,
            createdAt = 1741120800000L,
            resolvedAt = 1741120800000L
        )
        val reply2 = Reply(
            id = 2,
            name = "Sofia Ribeiro",
            subject = "Update on Monday's project",
            isResolved = true
        )
        val reply3 = Reply(
            id = 3,
            name = "Thiago Martins",
            subject = "Did you get a chance to check the contract?",
            isResolved = true
        )
        val reply4 = Reply(
            id = 4,
            name = "Marina Costa",
            subject = "You're invited to my birthday 🎉",
            isResolved = true
        )
        val reply5 = Reply(
            id = 5,
            name = "Diego Fernandes",
            subject = "Meeting moved to Friday, okay?",
            isResolved = true
        )

        val replies = listOf(reply1, reply2, reply3, reply4, reply5)
    }

    data object Archived : Replies() {
        val reply1 = Reply(
            id = 1,
            name = "Lucas Almeida",
            subject = "Wanna grab coffee sometime?",
            isArchived = true,
            isResolved = true,
            createdAt = 1741120800000L,
            resolvedAt = 1741120800000L,
            archivedAt = 1741120800000L
        )
        val reply2 = Reply(
            id = 2,
            name = "Sofia Ribeiro",
            subject = "Update on Monday's project",
            isArchived = true
        )
        val reply3 = Reply(
            id = 3,
            name = "Thiago Martins",
            subject = "Did you get a chance to check the contract?",
            isArchived = true,
            isResolved = true
        )
        val reply4 = Reply(
            id = 4,
            name = "Marina Costa",
            subject = "You're invited to my birthday 🎉",
            isArchived = true
        )
        val reply5 = Reply(
            id = 5,
            name = "Diego Fernandes",
            subject = "Meeting moved to Friday, okay?",
            isArchived = true
        )

        val replies = listOf(reply1, reply2, reply3, reply4, reply5)
    }
}
