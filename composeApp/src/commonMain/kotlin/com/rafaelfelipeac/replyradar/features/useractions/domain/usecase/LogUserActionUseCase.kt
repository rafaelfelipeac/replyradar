package com.rafaelfelipeac.replyradar.features.useractions.domain.usecase

import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository

interface LogUserActionUseCase {
    suspend fun logUserAction(actionType: String)
}

class LogUserActionUseCaseImpl(
    private val repository: UserActionRepository
) : LogUserActionUseCase {

    override suspend fun logUserAction(actionType: String) {
        repository.logUserAction(actionType = actionType)
    }
}
