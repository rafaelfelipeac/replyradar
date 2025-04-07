package com.rafaelfelipeac.replyradar.features.useractions.domain.usecase

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.repository.UserActionRepository
import kotlinx.coroutines.flow.Flow

interface GetUserActionItemsUseCase {
    suspend fun getUserActions(): Flow<List<UserAction>>
}

class GetUserActionItemsUseCaseImpl(
    private val repository: UserActionRepository
) : GetUserActionItemsUseCase {

    override suspend fun getUserActions(): Flow<List<UserAction>> {
        return repository.getUserActions()
    }
}
