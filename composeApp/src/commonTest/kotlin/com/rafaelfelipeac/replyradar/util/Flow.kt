package com.rafaelfelipeac.replyradar.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

suspend fun <T> Flow<List<T>>.valueOrEmpty(): List<T> = this.firstOrNull() ?: emptyList()
