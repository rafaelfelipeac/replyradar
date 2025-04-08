package com.rafaelfelipeac.replyradar.fakes.useractions.domain

import com.rafaelfelipeac.replyradar.features.useractions.domain.model.UserAction
import com.rafaelfelipeac.replyradar.features.useractions.domain.usecase.GetUserActionItemsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Suppress("TooGenericExceptionThrown")
class FakeGetUserActionItemsUseCase : GetUserActionItemsUseCase {

    var userActions: List<UserAction> = emptyList()
    var shouldThrow: Boolean = false

    override suspend fun getUserActions(): Flow<List<UserAction>> = flow {
        if (shouldThrow) throw RuntimeException("Fake error.")
        emit(userActions)
    }
}
