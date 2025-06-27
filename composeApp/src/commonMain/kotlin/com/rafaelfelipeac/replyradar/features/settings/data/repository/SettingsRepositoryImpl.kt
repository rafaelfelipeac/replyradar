package com.rafaelfelipeac.replyradar.features.settings.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.features.settings.data.repository.SettingsRepositoryImpl.Keys.LANGUAGE
import com.rafaelfelipeac.replyradar.features.settings.data.repository.SettingsRepositoryImpl.Keys.THEME
import com.rafaelfelipeac.replyradar.features.settings.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : SettingsRepository {

    private object Keys {
        val THEME = stringPreferencesKey(THEME_KEY)
        val LANGUAGE = stringPreferencesKey(LANGUAGE_KEY)
    }

    override fun getTheme(): Flow<AppTheme> {
        return dataStore.data.map { prefs ->
            prefs[THEME]?.let(AppTheme::fromString) ?: AppTheme.SYSTEM
        }
    }

    override suspend fun setTheme(theme: AppTheme) {
        dataStore.edit { prefs ->
            prefs[THEME] = theme.name
        }
    }

    override fun getLanguage(): Flow<AppLanguage> {
        return dataStore.data.map { prefs ->
            prefs[LANGUAGE]?.let(AppLanguage::fromString) ?: AppLanguage.SYSTEM
        }
    }

    override suspend fun setLanguage(language: AppLanguage) {
        dataStore.edit { prefs ->
            prefs[LANGUAGE] = language.name
        }
    }

    companion object {
        private const val THEME_KEY = "replyradar_theme"
        private const val LANGUAGE_KEY = "replyradar_language"
    }
}
