@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsDe : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "Ein unerwarteter Fehler ist aufgetreten."

    override val replyListActivityLog = "Aktivitätsprotokoll"
    override val replyListTabOnTheRadar = "Auf dem Radar"
    override val replyListTabResolved = "Erledigt"
    override val replyListTabArchived = "Archiviert"
    override val replyListPlaceholderOnTheRadar =
        "Momentan nichts auf dem Radar!\nWie wäre es, etwas hinzuzufügen?"
    override val replyListGetRepliesError = "Antworten konnten nicht geladen werden. Bitte versuche es erneut."
    override val replyListPlaceholderResolved =
        "Noch keine erledigten Antworten.\nZeit, etwas zu erledigen?"
    override val replyListPlaceholderArchived =
        "Archiv sieht leer aus!\nZeit, dein Radar zu leeren?"
    override val replyListBottomSheetName = "Name"
    override val replyListBottomSheetSubject = "Betreff"
    override val replyListBottomSheetAdd = "Hinzufügen"
    override val replyListBottomSheetSave = "Speichern"
    override val replyListBottomSheetResolve = "Erledigen"
    override val replyListBottomSheetReopen = "Wieder öffnen"
    override val replyListBottomSheetArchive = "Archivieren"
    override val replyListBottomSheetUnarchive = "Dearchivieren"
    override val replyListBottomSheetDelete = "Löschen"
    override val replyListItemResolve = "Erledigen"
    override val replyListItemCreatedAt = "Erstellt am: %1"
    override val replyListItemUpdatedAt = "Aktualisiert am: %1"
    override val replyListItemResolvedAt = "Erledigt am: %1"
    override val replyListItemArchivedAt = "Archiviert am: %1"
    override val replyListFabContentDescription = "Füge eine neue Antwort zu deinem Radar hinzu."
    override val replyListDeleteDialogTitle = "Bist du sicher?"
    override val replyListDeleteDialogDescription = "Diese Aktion löscht \"%1\" dauerhaft und kann nicht rückgängig gemacht werden."
    override val replyListDeleteDialogConfirm = "Löschen"
    override val replyListDeleteDialogDismiss = "Abbrechen"
    override val replyListSnackbarArchived = "Element erfolgreich archiviert."
    override val replyListSnackbarRemoved = "Element dauerhaft gelöscht."
    override val replyListSnackbarReopened = "Element wieder geöffnet und zurück auf dem Radar."
    override val replyListSnackbarResolved = "Element als erledigt markiert."
    override val replyListSnackbarUnarchived = "Element erfolgreich dearchiviert."
    override val replyListReminder = "Erinnerung"
    override val replyListReminderSet = "Erinnerung eingestellt für:"
    override val replyListReminderSetSeparator = "%1 um %2"
    override val replyListReminderToday = "heute"
    override val replyListReminderTomorrow = "morgen"
    override val replyListReminderTimeIconContentDescription = "Zeit"
    override val replyListReminderDateIconContentDescription = "Datum"
    override val replyListReminderCloseIconContentDescription = "Schließen"
    override val replyListReminderInvalidDateTime = "Das ausgewählte Datum und die Uhrzeit sind bereits vergangen."
    override val replyListReminderTimePickerTitle = "Zeit auswählen"
    override val replyListReminderTimePickerConfirmButton = "OK"
    override val replyListReminderTimePickerDismissButton = "Abbrechen"
    override val replyListReminderDatePickerConfirmButton = "OK"
    override val replyListReminderDatePickerDismissButton = "Abbrechen"

    override val settingsTitle = "Einstellungen"
    override val settingsBackButton = "Zurück"
    override val settingsTheme = "Thema"
    override val settingsThemeLight = "Hell"
    override val settingsThemeDark = "Dunkel"
    override val settingsThemeSystem = "Systemstandard verwenden"
    override val settingsLanguage = "Sprache"
    override val settingsLanguageEnglish = "Englisch"
    override val settingsLanguagePortuguese = "Portugiesisch"
    override val settingsLanguageGerman = "Deutsch"
    override val settingsLanguageFrench = "Französisch"
    override val settingsLanguageSpanish = "Spanisch"
    override val settingsLanguageSystem = "Systemstandard verwenden"
    override val settingsFeedbackTitle = "Feedback"
    override val settingsFeedbackDescription =
        "Sende uns eine E-Mail mit Fragen, Vorschlägen oder um einen Fehler zu melden. Dein Feedback hilft, Reply Radar zu verbessern!"
    override val settingsFeedbackEmailSubject = "Reply Radar - Feedback & Vorschläge"
    override val settingsFeedbackEmailBody = """
Hallo!

Fühle dich frei, deine Fragen, Vorschläge zu teilen oder einen Fehler zu melden.

Jedes Feedback ist sehr willkommen :)

---

App-Version: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "App bewerten"
    override val settingsRateDescription =
        "Gefällt dir Reply Radar? Hinterlasse eine Bewertung im Play Store und hilf anderen, die App zu entdecken!"
    override val settingsAppVersion = "Reply Radar - Version:"

    override val activityLogTitle = "Aktivitätsprotokoll"
    override val activityLogBackButton = "Zurück"
    override val activityLogItemContentDescription = "Aktivitätsprotokollelement"
    override val activityLogPlaceholder =
        "Noch keine Aktivität!\nDein Radar wartet auf Aktion."
    override val activityLogGetActivityLogsError =
        "Aktivitätsprotokoll konnte nicht geladen werden. Bitte versuche es erneut."
    override val activityLogMessageFormat = "Du hast %1 %2"
    override val activityLogMessageItem = "das Element \"%1\"."
    override val activityLogMessageItemRemoved = "ein Element, das nicht mehr existiert."
    override val activityLogUserActionArchiveVerb = "archiviert"
    override val activityLogUserActionCreateVerb = "erstellt"
    override val activityLogUserActionDeleteVerb = "gelöscht"
    override val activityLogUserActionEditVerb = "bearbeitet"
    override val activityLogUserActionReopenVerb = "wieder geöffnet"
    override val activityLogUserActionResolveVerb = "erledigt"
    override val activityLogUserActionUnarchiveVerb = "dearchiviert"
    override val activityLogUserActionOpenVerb = "geöffnet"
    override val activityLogUserActionScheduledVerb = "eine Erinnerung geplant für"
    override val activityLogUserActionOpenedNotificationVerb = "eine Benachrichtigung geöffnet für"
    override val activityLogUserActionTheme = "Du hast das App-Thema gewechselt."
    override val activityLogUserActionLanguage = "Du hast die App-Sprache geändert."
    override val activityLogUserActionFeedback = "Du hast Feedback zur App gegeben."
    override val activityLogUserActionRate = "Du hast die App bewertet."

    override val notificationPermissionDialogTitle = "Benachrichtigungsberechtigung"
    override val notificationPermissionDialogDescription = "Um dich daran zu erinnern, auf deine Nachrichten zu antworten, benötigen wir die Berechtigung, Benachrichtigungen zu senden. \n\nDu kannst sie in den App-Einstellungen aktivieren."
    override val notificationPermissionDialogConfirmButton = "Einstellungen öffnen"
    override val notificationPermissionDialogDismissButton = "Verstanden"
    override val notificationTitle = "Hey, wie wäre es mit einer Antwort an %1?"
    override val notificationContent = "%1 wartet auf deine Antwort zu \"%2\"."
    override val notificationContentWithoutSubject = "%1 wartet auf deine Antwort."
}
// ktlint-enable max-line-length
