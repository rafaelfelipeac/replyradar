package com.rafaelfelipeac.replyradar.features.useractions.domain.repository

interface UserActionRepository {
    suspend fun logUserAction(actionType: String)
}
