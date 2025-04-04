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
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.LIGHT
import com.rafaelfelipeac.replyradar.core.common.ui.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.settings_back_button
import replyradar.composeapp.generated.resources.settings_theme
import replyradar.composeapp.generated.resources.settings_theme_dark
import replyradar.composeapp.generated.resources.settings_theme_light
import replyradar.composeapp.generated.resources.settings_theme_system
import replyradar.composeapp.generated.resources.settings_title

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
                title = { Text(text = stringResource(string.settings_title)) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = stringResource(string.settings_back_button)
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
            Text(
                text = stringResource(string.settings_theme),
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(paddingXSmall))

            ThemeOptions(
                state = state,
                onThemeSelected = { theme -> viewModel.onIntent(OnSelectTheme(theme)) }
            )
        }
    }
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
        LIGHT -> stringResource(string.settings_theme_light)
        DARK -> stringResource(string.settings_theme_dark)
        SYSTEM -> stringResource(string.settings_theme_system)
    }
