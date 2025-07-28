@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsFr : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "Une erreur inattendue est survenue."

    override val replyListActivityLog = "Journal d'activité"
    override val replyListTabOnTheRadar = "Sur le radar"
    override val replyListTabResolved = "Résolu"
    override val replyListTabArchived = "Archivé"
    override val replyListPlaceholderOnTheRadar =
        "Rien sur le radar pour le moment !\nEt si vous ajoutiez quelque chose ?"
    override val replyListGetRepliesError = "Échec du chargement de vos réponses. Veuillez réessayer."
    override val replyListPlaceholderResolved =
        "Aucune réponse résolue pour le moment.\nIl est temps de passer à l'action ?"
    override val replyListPlaceholderArchived =
        "Les archives sont vides !\nIl est temps de vider votre radar ?"
    override val replyListBottomSheetName = "Nom"
    override val replyListBottomSheetSubject = "Sujet"
    override val replyListBottomSheetAdd = "Ajouter"
    override val replyListBottomSheetSave = "Enregistrer"
    override val replyListBottomSheetResolve = "Résoudre"
    override val replyListBottomSheetReopen = "Rouvrir"
    override val replyListBottomSheetArchive = "Archiver"
    override val replyListBottomSheetUnarchive = "Désarchiver"
    override val replyListBottomSheetDelete = "Supprimer"
    override val replyListItemResolve = "Résoudre"
    override val replyListItemCreatedAt = "Créé le : %1"
    override val replyListItemUpdatedAt = "Mis à jour le : %1"
    override val replyListItemResolvedAt = "Résolu le : %1"
    override val replyListItemArchivedAt = "Archivé le : %1"
    override val replyListFabContentDescription = "Ajoutez une nouvelle réponse à votre radar."
    override val replyListDeleteDialogTitle = "Êtes-vous sûr ?"
    override val replyListDeleteDialogDescription = "Cette action supprimera définitivement \"%1\" et ne pourra pas être annulée."
    override val replyListDeleteDialogConfirm = "Supprimer"
    override val replyListDeleteDialogDismiss = "Annuler"
    override val replyListSnackbarArchived = "Élément archivé avec succès."
    override val replyListSnackbarRemoved = "Élément supprimé définitivement."
    override val replyListSnackbarReopened = "Élément rouvert et de retour sur le radar."
    override val replyListSnackbarResolved = "Élément marqué comme résolu."
    override val replyListSnackbarUnarchived = "Élément désarchivé avec succès."
    override val replyListReminder = "Rappel"
    override val replyListReminderSet = "Rappel défini pour :"
    override val replyListReminderSetSeparator = "%1 à %2"
    override val replyListReminderToday = "aujourd'hui"
    override val replyListReminderTomorrow = "demain"
    override val replyListReminderTimeIconContentDescription = "Heure"
    override val replyListReminderDateIconContentDescription = "Date"
    override val replyListReminderCloseIconContentDescription = "Fermer"
    override val replyListReminderInvalidDateTime = "La date et l'heure sélectionnées sont déjà passées."
    override val replyListReminderTimePickerTitle = "Sélectionner l'heure"
    override val replyListReminderTimePickerConfirmButton = "OK"
    override val replyListReminderTimePickerDismissButton = "Annuler"
    override val replyListReminderDatePickerConfirmButton = "OK"
    override val replyListReminderDatePickerDismissButton = "Annuler"

    override val settingsTitle = "Paramètres"
    override val settingsBackButton = "Retour"
    override val settingsTheme = "Thème"
    override val settingsThemeLight = "Clair"
    override val settingsThemeDark = "Sombre"
    override val settingsThemeSystem = "Utiliser le thème par défaut du système"
    override val settingsLanguage = "Langue"
    override val settingsLanguageEnglish = "Anglais"
    override val settingsLanguagePortuguese = "Portugais"
    override val settingsLanguageGerman = "Allemand"
    override val settingsLanguageFrench = "Français"
    override val settingsLanguageSpanish = "Espagnol"
    override val settingsLanguageSystem = "Utiliser la langue par défaut du système"
    override val settingsFeedbackTitle = "Commentaires"
    override val settingsFeedbackDescription =
        "Envoyez-nous un e-mail avec vos questions, suggestions ou pour signaler un bug. Vos commentaires aident à améliorer Reply Radar !"
    override val settingsFeedbackEmailSubject = "Reply Radar - Commentaires & Suggestions"
    override val settingsFeedbackEmailBody = """
Bonjour !

N'hésitez pas à partager vos questions, suggestions ou à signaler un bug.

Tous les commentaires sont les bienvenus :)

---

Version de l'application : ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "Évaluer l'application"
    override val settingsRateDescription =
        "Vous aimez Reply Radar ? Laissez un avis sur le Play Store et aidez les autres à découvrir l'application !"
    override val settingsAppVersion = "Reply Radar - Version :"

    override val activityLogTitle = "Journal d'activité"
    override val activityLogBackButton = "Retour"
    override val activityLogItemContentDescription = "Élément du journal d'activité"
    override val activityLogPlaceholder =
        "Aucune activité pour le moment !\nVotre radar attend de l'action."
    override val activityLogGetActivityLogsError =
        "Échec du chargement de votre journal d'activité. Veuillez réessayer."
    override val activityLogMessageFormat = "Vous avez %1 %2"
    override val activityLogMessageItem = "l'élément \"%1\"."
    override val activityLogMessageItemRemoved = "un élément qui n'existe plus."
    override val activityLogUserActionArchiveVerb = "archivé"
    override val activityLogUserActionCreateVerb = "créé"
    override val activityLogUserActionDeleteVerb = "supprimé"
    override val activityLogUserActionEditVerb = "modifié"
    override val activityLogUserActionReopenVerb = "rouvert"
    override val activityLogUserActionResolveVerb = "résolu"
    override val activityLogUserActionUnarchiveVerb = "désarchivé"
    override val activityLogUserActionOpenVerb = "ouvert"
    override val activityLogUserActionScheduledVerb = "planifié un rappel pour"
    override val activityLogUserActionOpenedNotificationVerb = "ouvert une notification pour"
    override val activityLogUserActionTheme = "Vous avez changé le thème de l'application."
    override val activityLogUserActionLanguage = "Vous avez changé la langue de l'application."
    override val activityLogUserActionFeedback = "Vous avez donné votre avis sur l'application."
    override val activityLogUserActionRate = "Vous avez évalué l'application."

    override val notificationPermissionDialogTitle = "Autorisation de notification"
    override val notificationPermissionDialogDescription = "Pour vous rappeler de répondre à vos messages, nous avons besoin de l'autorisation d'envoyer des notifications. \n\nVous pouvez l'activer dans les paramètres de l'application."
    override val notificationPermissionDialogConfirmButton = "Ouvrir les paramètres"
    override val notificationPermissionDialogDismissButton = "Compris"
    override val notificationTitle = "Hey, et si vous répondiez à %1 ?"
    override val notificationContent = "%1 attend votre réponse concernant \"%2\"."
    override val notificationContentWithoutSubject = "%1 attend votre réponse."
}
// ktlint-enable max-line-length
