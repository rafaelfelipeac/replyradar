package com.rafaelfelipeac.replyradar.features.settings.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.ENGLISH
import com.rafaelfelipeac.replyradar.core.common.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.core.common.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.LIGHT
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectLanguage
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = koinViewModel(),
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = LocalReplyRadarStrings.current.settingsTitle) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = LocalReplyRadarStrings.current.settingsBackButton
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(paddingMedium)
        ) {
            Theme(state = state, viewModel = viewModel)
            Language(state = state, viewModel = viewModel)
        }
    }
}

@Composable
private fun Theme(
    state: SettingsState,
    viewModel: SettingsViewModel
) {
    Text(
        text = LocalReplyRadarStrings.current.settingsTheme,
        style = MaterialTheme.typography.titleMedium
    )

    Spacer(modifier = Modifier.height(paddingXSmall))

    ThemeOptions(
        state = state,
        onThemeSelected = { theme -> viewModel.onIntent(OnSelectTheme(theme)) }
    )
}

@Composable
private fun Language(
    state: SettingsState,
    viewModel: SettingsViewModel
) {
    Text(
        text = LocalReplyRadarStrings.current.settingsLanguage,
        style = MaterialTheme.typography.titleMedium
    )

    Spacer(modifier = Modifier.height(paddingXSmall))

    LanguageOptions(
        state = state,
        onLanguageSelected = { language ->
            viewModel.onIntent(OnSelectLanguage(language))
        }
    )
}

@Composable
private fun ThemeOptions(
    state: SettingsState,
    onThemeSelected: (AppTheme) -> Unit
) {
    ThemeOption(
        theme = LIGHT,
        selectedTheme = state.theme,
        onThemeSelected = { onThemeSelected(LIGHT) })
    ThemeOption(
        theme = DARK,
        selectedTheme = state.theme,
        onThemeSelected = { onThemeSelected(DARK) })
    ThemeOption(
        theme = SYSTEM,
        selectedTheme = state.theme,
        onThemeSelected = { onThemeSelected(SYSTEM) })
}

@Composable
private fun ThemeOption(
    theme: AppTheme,
    selectedTheme: AppTheme,
    onThemeSelected: (AppTheme) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onThemeSelected(theme) }
    ) {
        RadioButton(
            selected = theme == selectedTheme,
            onClick = { onThemeSelected(theme) }
        )

        Spacer(modifier = Modifier.width(paddingSmall))

        Text(text = getThemeOptionLabel(theme))
    }
}

@Composable
private fun getThemeOptionLabel(theme: AppTheme) =
    when (theme) {
        LIGHT -> LocalReplyRadarStrings.current.settingsThemeLight
        DARK -> LocalReplyRadarStrings.current.settingsThemeDark
        SYSTEM -> LocalReplyRadarStrings.current.settingsThemeSystem
    }

@Composable
private fun LanguageOptions(
    state: SettingsState,
    onLanguageSelected: (AppLanguage) -> Unit
) {
    LanguageOption(ENGLISH, state.language, onLanguageSelected)
    LanguageOption(PORTUGUESE, state.language, onLanguageSelected)
    LanguageOption(AppLanguage.SYSTEM, state.language, onLanguageSelected)
}

@Composable
private fun LanguageOption(
    language: AppLanguage,
    selectedLanguage: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onLanguageSelected(language) }
    ) {
        RadioButton(
            selected = language == selectedLanguage,
            onClick = { onLanguageSelected(language) }
        )

        Spacer(modifier = Modifier.width(paddingSmall))

        Text(text = getLanguageLabel(language))
    }
}

@Composable
private fun getLanguageLabel(language: AppLanguage) =
    when (language) {
        ENGLISH -> LocalReplyRadarStrings.current.settingsLanguageEnglish
        PORTUGUESE -> LocalReplyRadarStrings.current.settingsLanguagePortuguese
        AppLanguage.SYSTEM -> LocalReplyRadarStrings.current.settingsLanguageSystem
    }
