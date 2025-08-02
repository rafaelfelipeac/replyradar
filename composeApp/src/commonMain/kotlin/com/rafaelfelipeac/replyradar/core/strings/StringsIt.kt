@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsIt : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "Si è verificato un errore imprevisto."

    override val replyListActivityLog = "Registro attività"
    override val replyListTabOnTheRadar = "Sul radar"
    override val replyListTabResolved = "Risolto"
    override val replyListTabArchived = "Archiviato"
    override val replyListPlaceholderOnTheRadar =
        "Niente sul radar per ora!\nChe ne dici di aggiungere qualcosa?"
    override val replyListGetRepliesError = "Impossibile caricare le tue risposte. Riprova."
    override val replyListPlaceholderResolved =
        "Nessuna risposta risolta ancora.\nÈ ora di fare qualcosa?"
    override val replyListPlaceholderArchived =
        "L'archivio sembra vuoto!\nÈ ora di pulire il tuo radar?"
    override val replyListBottomSheetName = "Nome"
    override val replyListBottomSheetSubject = "Oggetto"
    override val replyListBottomSheetAdd = "Aggiungi"
    override val replyListBottomSheetSave = "Salva"
    override val replyListBottomSheetResolve = "Risolvi"
    override val replyListBottomSheetReopen = "Riapri"
    override val replyListBottomSheetArchive = "Archivia"
    override val replyListBottomSheetUnarchive = "Annulla archiviazione"
    override val replyListBottomSheetDelete = "Elimina"
    override val replyListItemResolve = "Risolvi"
    override val replyListItemCreatedAt = "Creato il: %1"
    override val replyListItemUpdatedAt = "Aggiornato il: %1"
    override val replyListItemResolvedAt = "Risolto il: %1"
    override val replyListItemArchivedAt = "Archiviato il: %1"
    override val replyListFabContentDescription = "Aggiungi una nuova risposta al tuo radar."
    override val replyListDeleteDialogTitle = "Sei sicuro?"
    override val replyListDeleteDialogDescription = "Questa azione eliminerà permanentemente \"%1\" e non potrà essere annullata."
    override val replyListDeleteDialogConfirm = "Elimina"
    override val replyListDeleteDialogDismiss = "Annulla"
    override val replyListSnackbarArchived = "Elemento archiviato con successo."
    override val replyListSnackbarRemoved = "Elemento eliminato definitivamente."
    override val replyListSnackbarReopened = "Elemento riaperto e di nuovo sul radar."
    override val replyListSnackbarResolved = "Elemento contrassegnato come risolto."
    override val replyListSnackbarUnarchived = "Archiviazione dell'elemento annullata con successo."
    override val replyListReminder = "Promemoria"
    override val replyListReminderSet = "Promemoria impostato per:"
    override val replyListReminderSetSeparator = "%1 alle %2"
    override val replyListReminderToday = "oggi"
    override val replyListReminderTomorrow = "domani"
    override val replyListReminderTimeIconContentDescription = "Ora"
    override val replyListReminderDateIconContentDescription = "Data"
    override val replyListReminderCloseIconContentDescription = "Chiudi"
    override val replyListReminderInvalidDateTime = "La data e l'ora selezionate sono già passate."
    override val replyListReminderTimePickerTitle = "Seleziona l'ora"
    override val replyListReminderTimePickerConfirmButton = "OK"
    override val replyListReminderTimePickerDismissButton = "Annulla"
    override val replyListReminderDatePickerConfirmButton = "OK"
    override val replyListReminderDatePickerDismissButton = "Annulla"

    override val settingsTitle = "Impostazioni"
    override val settingsBackButton = "Indietro"
    override val settingsTheme = "Tema"
    override val settingsThemeLight = "Chiaro"
    override val settingsThemeDark = "Scuro"
    override val settingsThemeSystem = "Usa predefinito di sistema"
    override val settingsLanguage = "Lingua"
    override val settingsLanguageEnglish = "Inglese"
    override val settingsLanguagePortuguese = "Portoghese"
    override val settingsLanguageGerman = "Tedesco"
    override val settingsLanguageFrench = "Francese"
    override val settingsLanguageSpanish = "Spagnolo"
    override val settingsLanguageSystem = "Usa predefinito di sistema"
    override val settingsFeedbackTitle = "Feedback"
    override val settingsFeedbackDescription =
        "Inviaci un'e-mail con domande, suggerimenti o per segnalare un bug. Il tuo feedback aiuta a migliorare Reply Radar!"
    override val settingsFeedbackEmailSubject = "Reply Radar - Feedback e suggerimenti"
    override val settingsFeedbackEmailBody = """
Ciao!

Sentiti libero di condividere le tue domande, suggerimenti o segnalare un bug.

Ogni feedback è molto gradito :)

---

Versione dell'app: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "Valuta l'app"
    override val settingsRateDescription =
        "Ti piace Reply Radar? Lascia una recensione sul Play Store e aiuta gli altri a scoprire l'app!"
    override val settingsAppVersion = "Reply Radar - Versione:"

    override val activityLogTitle = "Registro attività"
    override val activityLogBackButton = "Indietro"
    override val activityLogItemContentDescription = "Elemento del registro attività"
    override val activityLogPlaceholder =
        "Nessuna attività per ora!\nIl tuo radar attende qualche azione."
    override val activityLogGetActivityLogsError =
        "Impossibile caricare il registro attività. Riprova."
    override val activityLogMessageFormat = "Hai %1 %2"
    override val activityLogMessageItem = "l'elemento \"%1\"."
    override val activityLogMessageItemRemoved = "un elemento che non esiste più."
    override val activityLogUserActionArchiveVerb = "archiviato"
    override val activityLogUserActionCreateVerb = "creato"
    override val activityLogUserActionDeleteVerb = "eliminato"
    override val activityLogUserActionEditVerb = "modificato"
    override val activityLogUserActionReopenVerb = "riaperto"
    override val activityLogUserActionResolveVerb = "risolto"
    override val activityLogUserActionUnarchiveVerb = "annullato l'archiviazione"
    override val activityLogUserActionOpenVerb = "aperto"
    override val activityLogUserActionScheduledVerb = "programmato un promemoria per"
    override val activityLogUserActionOpenedNotificationVerb = "aperto una notifica per"
    override val activityLogUserActionTheme = "Hai cambiato il tema dell'app."
    override val activityLogUserActionLanguage = "Hai cambiato la lingua dell'app."
    override val activityLogUserActionFeedback = "Hai dato un feedback sull'app."
    override val activityLogUserActionRate = "Hai valutato l'app."

    override val notificationPermissionDialogTitle = "Autorizzazione per le notifiche"
    override val notificationPermissionDialogDescription = "Per ricordarti di rispondere ai tuoi messaggi, abbiamo bisogno dell'autorizzazione per inviare notifiche. \n\nPuoi abilitarla nelle impostazioni dell'app."
    override val notificationPermissionDialogConfirmButton = "Apri impostazioni"
    override val notificationPermissionDialogDismissButton = "Capito"
    override val notificationTitle = "Ehi, che ne dici di rispondere a %1?"
    override val notificationContent = "%1 sta aspettando la tua risposta riguardo a \"%2\"."
    override val notificationContentWithoutSubject = "%1 sta aspettando la tua risposta."
}
// ktlint-enable max-line-length
