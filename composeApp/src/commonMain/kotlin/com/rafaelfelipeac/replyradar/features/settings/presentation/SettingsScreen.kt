package com.rafaelfelipeac.replyradar.features.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rafaelfelipeac.replyradar.core.common.ui.iconSizeLarge
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.common.ui.paddingXSmall
import com.rafaelfelipeac.replyradar.core.common.ui.radioButtonSize
import com.rafaelfelipeac.replyradar.core.common.ui.settingsAppVersionOffset
import com.rafaelfelipeac.replyradar.core.external.openEmailApp
import com.rafaelfelipeac.replyradar.core.external.openPlayStoreApp
import com.rafaelfelipeac.replyradar.core.language.AppLanguage
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.ENGLISH
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.FRENCH
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.GERMAN
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.PORTUGUESE
import com.rafaelfelipeac.replyradar.core.language.AppLanguage.SPANISH
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.DARK
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.LIGHT
import com.rafaelfelipeac.replyradar.core.theme.model.AppTheme.SYSTEM
import com.rafaelfelipeac.replyradar.core.util.AppConstants.EMAIL
import com.rafaelfelipeac.replyradar.core.util.AppConstants.PACKAGE_NAME
import com.rafaelfelipeac.replyradar.core.version.getAppVersion
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectFeedback
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectLanguage
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectRate
import com.rafaelfelipeac.replyradar.features.settings.presentation.SettingsIntent.OnSelectTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import replyradar.composeapp.generated.resources.Res.drawable
import replyradar.composeapp.generated.resources.ic_email
import replyradar.composeapp.generated.resources.ic_rate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = koinViewModel(),
    onBackClick: () -> Unit,
    onActivityLogClick: () -> Unit
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
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .padding(paddingMedium)
                .fillMaxSize()
        ) {
            val scrollState = rememberScrollState()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(bottom = settingsAppVersionOffset)
            ) {
                ActivityLog(onActivityLogClick = onActivityLogClick)

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = paddingMedium)
                )

                Theme(state = state, onIntent = { viewModel.onIntent(it) })

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = paddingMedium)
                )

                Language(state = state, onIntent = { viewModel.onIntent(it) })

                HorizontalDivider(
                    modifier = Modifier
                        .padding(vertical = paddingMedium)
                )

                App(onIntent = { viewModel.onIntent(it) })
            }

            AppVersionFooter(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun App(onIntent: (SettingsIntent) -> Unit) {
    val strings = LocalReplyRadarStrings.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        SettingsItem(
            text = strings.settingsFeedbackTitle,
            description = strings.settingsFeedbackDescription,
            icon = drawable.ic_email,
            onClick = {
                openEmailApp(
                    to = EMAIL,
                    subject = strings.settingsFeedbackEmailSubject,
                    body = strings.settingsFeedbackEmailBody
                )
                onIntent(OnSelectFeedback)
            }
        )

        Spacer(
            modifier = Modifier
                .height(paddingSmall)
        )

        SettingsItem(
            text = strings.settingsRateTitle,
            description = strings.settingsRateDescription,
            icon = drawable.ic_rate,
            onClick = {
                openPlayStoreApp(PACKAGE_NAME)
                onIntent(OnSelectRate)
            }
        )
    }
}

@Composable
private fun ActivityLog(onActivityLogClick: () -> Unit) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onActivityLogClick() },
        text = LocalReplyRadarStrings.current.activityLogTitle
    )
}

@Composable
private fun Theme(state: SettingsState, onIntent: (SettingsIntent) -> Unit) {
    Text(
        text = LocalReplyRadarStrings.current.settingsTheme,
        style = typography.titleMedium,
        color = colorScheme.primary
    )

    Spacer(
        modifier = Modifier
            .height(paddingXSmall)
    )

    ThemeOptions(
        state = state,
        onThemeSelected = { theme -> onIntent(OnSelectTheme(theme)) }
    )
}

@Composable
private fun Language(state: SettingsState, onIntent: (SettingsIntent) -> Unit) {
    Text(
        text = LocalReplyRadarStrings.current.settingsLanguage,
        style = typography.titleMedium,
        color = colorScheme.primary
    )

    Spacer(
        modifier = Modifier
            .height(paddingXSmall)
    )

    LanguageOptions(
        state = state,
        onLanguageSelected = { language -> onIntent(OnSelectLanguage(language)) }
    )
}

@Composable
private fun ThemeOptions(state: SettingsState, onThemeSelected: (AppTheme) -> Unit) {
    ThemeOption(
        theme = LIGHT,
        selectedTheme = state.theme,
        onThemeSelected = { onThemeSelected(LIGHT) }
    )

    ThemeOption(
        theme = DARK,
        selectedTheme = state.theme,
        onThemeSelected = { onThemeSelected(DARK) }
    )

    ThemeOption(
        theme = SYSTEM,
        selectedTheme = state.theme,
        onThemeSelected = { onThemeSelected(SYSTEM) }
    )
}

@Composable
private fun ThemeOption(
    theme: AppTheme,
    selectedTheme: AppTheme,
    onThemeSelected: (AppTheme) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingSmall)
            .clickable { onThemeSelected(theme) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            modifier = Modifier
                .size(radioButtonSize),
            selected = theme == selectedTheme,
            onClick = { onThemeSelected(theme) }
        )

        Spacer(
            modifier = Modifier
                .width(paddingSmall)
        )

        Text(text = getThemeOptionLabel(theme))
    }
}

@Composable
private fun getThemeOptionLabel(theme: AppTheme) = when (theme) {
    LIGHT -> LocalReplyRadarStrings.current.settingsThemeLight
    DARK -> LocalReplyRadarStrings.current.settingsThemeDark
    SYSTEM -> LocalReplyRadarStrings.current.settingsThemeSystem
}

@Composable
private fun LanguageOptions(state: SettingsState, onLanguageSelected: (AppLanguage) -> Unit) {
    LanguageOption(ENGLISH, state.language, onLanguageSelected)
    LanguageOption(PORTUGUESE, state.language, onLanguageSelected)
    LanguageOption(GERMAN, state.language, onLanguageSelected)
    LanguageOption(FRENCH, state.language, onLanguageSelected)
    LanguageOption(SPANISH, state.language, onLanguageSelected)
    LanguageOption(AppLanguage.SYSTEM, state.language, onLanguageSelected)
}

@Composable
private fun LanguageOption(
    language: AppLanguage,
    selectedLanguage: AppLanguage,
    onLanguageSelected: (AppLanguage) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingSmall)
            .clickable { onLanguageSelected(language) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            modifier = Modifier
                .size(radioButtonSize),
            selected = language == selectedLanguage,
            onClick = { onLanguageSelected(language) }
        )

        Spacer(
            modifier = Modifier
                .width(paddingSmall)
        )

        Text(text = getLanguageLabel(language))
    }
}

@Composable
private fun getLanguageLabel(language: AppLanguage) = when (language) {
    ENGLISH -> LocalReplyRadarStrings.current.settingsLanguageEnglish
    PORTUGUESE -> LocalReplyRadarStrings.current.settingsLanguagePortuguese
    GERMAN -> LocalReplyRadarStrings.current.settingsLanguageGerman
    FRENCH -> LocalReplyRadarStrings.current.settingsLanguageFrench
    SPANISH -> LocalReplyRadarStrings.current.settingsLanguageSpanish
    AppLanguage.SYSTEM -> LocalReplyRadarStrings.current.settingsLanguageSystem
}

@Composable
fun SettingsItem(text: String, description: String, icon: DrawableResource, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = paddingSmall)
    ) {
        Icon(
            modifier = Modifier
                .padding(end = paddingMedium)
                .size(iconSizeLarge),
            painter = painterResource(icon),
            tint = colorScheme.primary,
            contentDescription = null
        )

        Column {
            Text(
                modifier = Modifier,
                text = text,
                color = colorScheme.primary
            )

            Text(
                modifier = Modifier,
                text = description,
                style = typography.bodyMedium
            )
        }
    }
}

@Composable
fun AppVersionFooter(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(colorScheme.background)
    ) {
        HorizontalDivider(
            modifier = Modifier
                .padding(bottom = paddingMedium)
        )

        Text(
            text = "${LocalReplyRadarStrings.current.settingsAppVersion} ${getAppVersion()}",
            style = typography.bodySmall,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = paddingMedium)
        )
    }
}
