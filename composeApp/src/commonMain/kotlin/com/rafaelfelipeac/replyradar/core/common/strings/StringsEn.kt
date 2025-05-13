package com.rafaelfelipeac.replyradar.core.common.strings

import com.rafaelfelipeac.replyradar.core.util.getAppVersion

object StringsEn : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "An unexpected error occurred."

    override val replyListActivityLog = "Activity Log"
    override val replyListTabOnTheRadar = "On the Radar"
    override val replyListTabResolved = "Resolved"
    override val replyListTabArchived = "Archived"
    override val replyListPlaceholderOnTheRadar =
        "Nothing on the radar for now!\nHow about adding something?"
    override val replyListGetRepliesError = "Failed to load your replies. Please try again."
    override val replyListPlaceholderResolved =
        "No resolved replies yet.\nTime to get something done?"
    override val replyListPlaceholderArchived =
        "Archive’s looking empty!\nTime to clear your radar?"
    override val replyListBottomSheetName = "Name"
    override val replyListBottomSheetSubject = "Subject"
    override val replyListBottomSheetAdd = "Add"
    override val replyListBottomSheetSave = "Save"
    override val replyListBottomSheetResolve = "Resolve"
    override val replyListBottomSheetReopen = "Reopen"
    override val replyListBottomSheetArchive = "Archive"
    override val replyListBottomSheetUnarchive = "Unarchive"
    override val replyListBottomSheetDelete = "Delete"
    override val replyListItemResolve = "Resolve"
    override val replyListItemCreatedAt = "Created at: %1"
    override val replyListItemUpdatedAt = "Updated at: %1"
    override val replyListItemResolvedAt = "Resolved at: %1"
    override val replyListItemArchivedAt = "Archived at: %1"
    override val replyListFabContentDescription = "Add a new reply to your radar."
    override val replyListDeleteDialogTitle = "Are you sure?"
    override val replyListDeleteDialogDescription = "This action will permanently delete \"%1\" and cannot be undone."
    override val replyListDeleteDialogConfirm = "Delete"
    override val replyListDeleteDialogDismiss = "Cancel"
    override val replyListSnackbarArchived = "Item successfully archived."
    override val replyListSnackbarRemoved = "Item permanently deleted."
    override val replyListSnackbarReopened = "Item reopened and back on the radar."
    override val replyListSnackbarResolved = "Item marked as resolved."
    override val replyListSnackbarUnarchived = "Item successfully unarchived."
    override val replyListReminder = "Reminder"
    override val replyListReminderSet = "Reminder set for:"
    override val replyListReminderToday = "today"
    override val replyListReminderTomorrow = "tomorrow"
    override val replyListReminderTimeIconContentDescription = "Time"
    override val replyListReminderDateIconContentDescription = "Date"
    override val replyListReminderCloseIconContentDescription = "Close"
    override val replyListReminderTimePickerTitle = "Select time"
    override val replyListReminderTimePickerConfirmButton = "OK"
    override val replyListReminderTimePickerDismissButton = "Cancel"
    override val replyListReminderDatePickerConfirmButton = "OK"
    override val replyListReminderDatePickerDismissButton = "Cancel"

    override val settingsTitle = "Settings"
    override val settingsBackButton = "Back"
    override val settingsTheme = "Theme"
    override val settingsThemeLight = "Light"
    override val settingsThemeDark = "Dark"
    override val settingsThemeSystem = "Use system default"
    override val settingsLanguage = "Language"
    override val settingsLanguageEnglish = "English"
    override val settingsLanguagePortuguese = "Portuguese"
    override val settingsLanguageSystem = "Use system default"
    override val settingsFeedbackTitle = "Feedback"
    override val settingsFeedbackDescription =
        "Send us an email with questions, suggestions or to report a bug. Your feedback helps make Reply Radar better!"
    override val settingsFeedbackEmailSubject = "Reply Radar - Feedback & Suggestions"
    override val settingsFeedbackEmailBody = """
Hello!

Feel free to share your questions, suggestions or report a bug. 

All feedback is very welcome :)

---

App version: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "Rate the app"
    override val settingsRateDescription =
        "Enjoying Reply Radar? Leave a review on the Play Store and help others discover the app!"
    override val settingsAppVersion = "Reply Radar - Version:"

    override val activityLogTitle = "Activity Log"
    override val activityLogBackButton = "Back"
    override val activityLogItemContentDescription = "Activity log item"
    override val activityLogPlaceholder =
        "No activity just yet!\nYour radar’s waiting for some action."
    override val activityLogGetActivityLogsError =
        "Failed to load your activity log. Please try again."
    override val activityLogMessageFormat = "You %1 %2"
    override val activityLogMessageItem = "the item \"%1\"."
    override val activityLogMessageItemRemoved = "an item that no longer exists."
    override val activityLogUserActionArchiveVerb = "archived"
    override val activityLogUserActionCreateVerb = "created"
    override val activityLogUserActionDeleteVerb = "deleted"
    override val activityLogUserActionEditVerb = "edited"
    override val activityLogUserActionReopenVerb = "reopened"
    override val activityLogUserActionResolveVerb = "resolved"
    override val activityLogUserActionUnarchiveVerb = "unarchived"
    override val activityLogUserActionOpenVerb = "opened"
    override val activityLogUserActionTheme = "You switched the app theme."
    override val activityLogUserActionLanguage = "You changed the app language."
    override val activityLogUserActionFeedback = "You gave feedback about the app."
    override val activityLogUserActionRate = "You rated the app."

    override val notificationPermissionDialogTitle = "Notification Permission"
    override val notificationPermissionDialogDescription = "To remind you to reply to your messages, we need permission to send notifications. \n\nYou can enable it in the app settings."
    override val notificationPermissionDialogConfirmButton = "Open Settings"
    override val notificationPermissionDialogDismissButton = "Got it"
}
