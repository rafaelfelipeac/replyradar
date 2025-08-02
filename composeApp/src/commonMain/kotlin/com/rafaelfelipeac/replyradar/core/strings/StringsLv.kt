@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsLv : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "Radās neparedzēta kļūda."

    override val replyListActivityLog = "Darbību žurnāls"
    override val replyListTabOnTheRadar = "Radarā"
    override val replyListTabResolved = "Atrisināts"
    override val replyListTabArchived = "Arhivēts"
    override val replyListPlaceholderOnTheRadar =
        "Pagaidām radarā nekā nav!\nKā būtu ar kaut ko pievienot?"
    override val replyListGetRepliesError = "Neizdevās ielādēt jūsu atbildes. Lūdzu, mēģiniet vēlreiz."
    override val replyListPlaceholderResolved =
        "Vēl nav atrisinātu atbilžu.\nLaiks kaut ko paveikt?"
    override val replyListPlaceholderArchived =
        "Arhīvs izskatās tukšs!\nLaiks iztīrīt radaru?"
    override val replyListBottomSheetName = "Vārds"
    override val replyListBottomSheetSubject = "Temats"
    override val replyListBottomSheetAdd = "Pievienot"
    override val replyListBottomSheetSave = "Saglabāt"
    override val replyListBottomSheetResolve = "Atrisināt"
    override val replyListBottomSheetReopen = "Atvērt no jauna"
    override val replyListBottomSheetArchive = "Arhivēt"
    override val replyListBottomSheetUnarchive = "Atarhivēt"
    override val replyListBottomSheetDelete = "Dzēst"
    override val replyListItemResolve = "Atrisināt"
    override val replyListItemCreatedAt = "Izveidots: %1"
    override val replyListItemUpdatedAt = "Atjaunināts: %1"
    override val replyListItemResolvedAt = "Atrisināts: %1"
    override val replyListItemArchivedAt = "Arhivēts: %1"
    override val replyListFabContentDescription = "Pievienot jaunu atbildi savam radaram."
    override val replyListDeleteDialogTitle = "Vai esat pārliecināts?"
    override val replyListDeleteDialogDescription = "Šī darbība neatgriezeniski izdzēsīs \"%1\" un to nevarēs atsaukt."
    override val replyListDeleteDialogConfirm = "Dzēst"
    override val replyListDeleteDialogDismiss = "Atcelt"
    override val replyListSnackbarArchived = "Vienums veiksmīgi arhivēts."
    override val replyListSnackbarRemoved = "Vienums neatgriezeniski izdzēsts."
    override val replyListSnackbarReopened = "Vienums atkārtoti atvērts un atgriezts radarā."
    override val replyListSnackbarResolved = "Vienums atzīmēts kā atrisināts."
    override val replyListSnackbarUnarchived = "Vienums veiksmīgi atarhivēts."
    override val replyListReminder = "Atgādinājums"
    override val replyListReminderSet = "Atgādinājums iestatīts:"
    override val replyListReminderSetSeparator = "%1 plkst. %2"
    override val replyListReminderToday = "šodien"
    override val replyListReminderTomorrow = "rīt"
    override val replyListReminderTimeIconContentDescription = "Laiks"
    override val replyListReminderDateIconContentDescription = "Datums"
    override val replyListReminderCloseIconContentDescription = "Aizvērt"
    override val replyListReminderInvalidDateTime = "Izvēlētais datums un laiks jau ir pagājis."
    override val replyListReminderTimePickerTitle = "Atlasīt laiku"
    override val replyListReminderTimePickerConfirmButton = "Labi"
    override val replyListReminderTimePickerDismissButton = "Atcelt"
    override val replyListReminderDatePickerConfirmButton = "Labi"
    override val replyListReminderDatePickerDismissButton = "Atcelt"

    override val settingsTitle = "Iestatījumi"
    override val settingsBackButton = "Atpakaļ"
    override val settingsTheme = "Tēma"
    override val settingsThemeLight = "Gaišs"
    override val settingsThemeDark = "Tumšs"
    override val settingsThemeSystem = "Izmantot sistēmas noklusējumu"
    override val settingsLanguage = "Valoda"
    override val settingsLanguageEnglish = "Angļu"
    override val settingsLanguagePortuguese = "Portugāļu"
    override val settingsLanguageGerman = "Vācu"
    override val settingsLanguageFrench = "Franču"
    override val settingsLanguageSpanish = "Spāņu"
    override val settingsLanguageSystem = "Izmantot sistēmas noklusējumu"
    override val settingsFeedbackTitle = "Atsauksmes"
    override val settingsFeedbackDescription =
        "Sūtiet mums e-pastu ar jautājumiem, ieteikumiem vai lai ziņotu par kļūdu. Jūsu atsauksmes palīdz uzlabot Reply Radar!"
    override val settingsFeedbackEmailSubject = "Reply Radar — atsauksmes un ieteikumi"
    override val settingsFeedbackEmailBody = """
Sveiki!

Droši dalieties ar saviem jautājumiem, ieteikumiem vai ziņojiet par kļūdu.

Jebkura atsauksme ir ļoti gaidīta :)

---

Lietotnes versija: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "Novērtējiet lietotni"
    override val settingsRateDescription =
        "Vai jums patīk Reply Radar? Atstājiet atsauksmi Play veikalā un palīdziet citiem atklāt lietotni!"
    override val settingsAppVersion = "Reply Radar — versija:"

    override val activityLogTitle = "Darbību žurnāls"
    override val activityLogBackButton = "Atpakaļ"
    override val activityLogItemContentDescription = "Darbību žurnāla vienums"
    override val activityLogPlaceholder =
        "Pagaidām nav darbību!\nJūsu radars gaida kādu darbību."
    override val activityLogGetActivityLogsError =
        "Neizdevās ielādēt jūsu darbību žurnālu. Lūdzu, mēģiniet vēlreiz."
    override val activityLogMessageFormat = "Jūs %1 %2"
    override val activityLogMessageItem = "vienumu \"%1\"."
    override val activityLogMessageItemRemoved = "vienumu, kas vairs nepastāv."
    override val activityLogUserActionArchiveVerb = "arhivējāt"
    override val activityLogUserActionCreateVerb = "izveidojāt"
    override val activityLogUserActionDeleteVerb = "izdzēsāt"
    override val activityLogUserActionEditVerb = "rediģējāt"
    override val activityLogUserActionReopenVerb = "atkārtoti atvērāt"
    override val activityLogUserActionResolveVerb = "atrisinājāt"
    override val activityLogUserActionUnarchiveVerb = "atarhivējāt"
    override val activityLogUserActionOpenVerb = "atvērāt"
    override val activityLogUserActionScheduledVerb = "ieplānojāt atgādinājumu"
    override val activityLogUserActionOpenedNotificationVerb = "atvērāt paziņojumu par"
    override val activityLogUserActionTheme = "Jūs nomainījāt lietotnes tēmu."
    override val activityLogUserActionLanguage = "Jūs nomainījāt lietotnes valodu."
    override val activityLogUserActionFeedback = "Jūs sniedzāt atsauksmes par lietotni."
    override val activityLogUserActionRate = "Jūs novērtējāt lietotni."

    override val notificationPermissionDialogTitle = "Paziņojumu atļauja"
    override val notificationPermissionDialogDescription = "Lai atgādinātu jums atbildēt uz ziņojumiem, mums ir nepieciešama atļauja sūtīt paziņojumus. \n\nTo varat iespējot lietotnes iestatījumos."
    override val notificationPermissionDialogConfirmButton = "Atvērt iestatījumus"
    override val notificationPermissionDialogDismissButton = "Sapratu"
    override val notificationTitle = "Hei, kā būtu ar atbildi %1?"
    override val notificationContent = "%1 gaida jūsu atbildi par \"%2\"."
    override val notificationContentWithoutSubject = "%1 gaida jūsu atbildi."
}
// ktlint-enable max-line-length
