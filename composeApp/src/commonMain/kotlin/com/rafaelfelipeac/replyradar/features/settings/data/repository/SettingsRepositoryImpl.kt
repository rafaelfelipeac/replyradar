package com.rafaelfelipeac.replyradar.features.settings.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.features.settings.data.repository.SettingsRepositoryImpl.Keys.THEME
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {

    private object Keys {
        val THEME = stringPreferencesKey(THEME_KEY)
    }

    override fun getTheme(): Flow<AppTheme> {
        return dataStore.data.map { prefs ->
            prefs[THEME]?.let(AppTheme::fromString) ?: SYSTEM
        }
    }

    override suspend fun setTheme(theme: AppTheme) {
        dataStore.edit { prefs ->
            prefs[THEME] = theme.name
        }
    }

    companion object {
        private const val THEME_KEY = "replyradar_theme"
    }
}
