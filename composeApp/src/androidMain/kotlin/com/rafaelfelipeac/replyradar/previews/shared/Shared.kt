package com.rafaelfelipeac.replyradar.previews.shared

import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionTargetType
import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserActionType

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

val previewActivityLogItems = listOf(
    UserAction(
        id = 1L,
        actionType = UserActionType.Create,
        targetType = UserActionTargetType.Message,
        targetName = "Lucas Almeida",
        createdAt = System.currentTimeMillis()
    ),
    UserAction(
        id = 2L,
        actionType = UserActionType.Edit,
        targetType = UserActionTargetType.Message,
        targetName = "Carla Mendes",
        createdAt = System.currentTimeMillis() - 1_000_000L
    ),
    UserAction(
        id = 3L,
        actionType = UserActionType.Resolve,
        targetType = UserActionTargetType.Message,
        targetName = "João Victor",
        createdAt = System.currentTimeMillis() - 2_000_000L
    ),
    UserAction(
        id = 4L,
        actionType = UserActionType.Archive,
        targetType = UserActionTargetType.Message,
        targetName = "Ana Paula",
        createdAt = System.currentTimeMillis() - 3_000_000L
    ),
    UserAction(
        id = 5L,
        actionType = UserActionType.OpenedNotification,
        targetType = UserActionTargetType.Message,
        targetName = "Marcelo Costa",
        createdAt = System.currentTimeMillis() - 4_000_000L
    ),
    UserAction(
        id = 6L,
        actionType = UserActionType.Open,
        targetType = UserActionTargetType.Message,
        targetName = "Beatriz Rocha",
        createdAt = System.currentTimeMillis() - 5_000_000L
    ),
    UserAction(
        id = 7L,
        actionType = UserActionType.Delete,
        targetType = UserActionTargetType.Message,
        targetName = "Henrique Silva",
        createdAt = System.currentTimeMillis() - 6_000_000L
    ),
    UserAction(
        id = 8L,
        actionType = UserActionType.Scheduled,
        targetType = UserActionTargetType.Message,
        targetName = "Fernanda Luz",
        createdAt = System.currentTimeMillis() - 7_000_000L
    ),
    UserAction(
        id = 9L,
        actionType = UserActionType.Create,
        targetType = UserActionTargetType.Feedback,
        targetName = null,
        createdAt = System.currentTimeMillis() - 8_000_000L
    ),
    UserAction(
        id = 10L,
        actionType = UserActionType.Create,
        targetType = UserActionTargetType.Language,
        targetName = null,
        createdAt = System.currentTimeMillis() - 9_000_000L
    ),
    UserAction(
        id = 11L,
        actionType = UserActionType.Create,
        targetType = UserActionTargetType.Theme,
        targetName = null,
        createdAt = System.currentTimeMillis() - 10_000_000L
    ),
    UserAction(
        id = 12L,
        actionType = UserActionType.Create,
        targetType = UserActionTargetType.Rate,
        targetName = null,
        createdAt = System.currentTimeMillis() - 11_000_000L
    )
)
