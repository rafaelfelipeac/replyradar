@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsHi : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "एक अप्रत्याशित त्रुटि हुई।"

    override val replyListActivityLog = "गतिविधि लॉग"
    override val replyListTabOnTheRadar = "रडार पर"
    override val replyListTabResolved = "हल किया गया"
    override val replyListTabArchived = "संग्रहीत"
    override val replyListPlaceholderOnTheRadar =
        "अभी रडार पर कुछ भी नहीं है!\nकुछ जोड़ने के बारे में क्या ख़याल है?"
    override val replyListGetRepliesError = "आपके उत्तर लोड करने में विफल। कृपया पुन: प्रयास करें।"
    override val replyListPlaceholderResolved =
        "अभी तक कोई हल किया गया उत्तर नहीं है।\nकुछ करने का समय है?"
    override val replyListPlaceholderArchived =
        "संग्रह खाली दिख रहा है!\nअपने रडार को साफ़ करने का समय है?"
    override val replyListBottomSheetName = "नाम"
    override val replyListBottomSheetSubject = "विषय"
    override val replyListBottomSheetAdd = "जोड़ें"
    override val replyListBottomSheetSave = "सहेजें"
    override val replyListBottomSheetResolve = "हल करें"
    override val replyListBottomSheetReopen = "पुनः खोलें"
    override val replyListBottomSheetArchive = "संग्रहीत करें"
    override val replyListBottomSheetUnarchive = "असंग्रहीत करें"
    override val replyListBottomSheetDelete = "हटाएं"
    override val replyListItemResolve = "हल करें"
    override val replyListItemCreatedAt = "पर बनाया गया: %1"
    override val replyListItemUpdatedAt = "पर अपडेट किया गया: %1"
    override val replyListItemResolvedAt = "पर हल किया गया: %1"
    override val replyListItemArchivedAt = "पर संग्रहीत किया गया: %1"
    override val replyListFabContentDescription = "अपने रडार में एक नया उत्तर जोड़ें।"
    override val replyListDeleteDialogTitle = "क्या आप निश्चित हैं?"
    override val replyListDeleteDialogDescription = "यह कार्रवाई \"%1\" को स्थायी रूप से हटा देगी और इसे पूर्ववत नहीं किया जा सकता है।"
    override val replyListDeleteDialogConfirm = "हटाएं"
    override val replyListDeleteDialogDismiss = "रद्द करें"
    override val replyListSnackbarArchived = "आइटम सफलतापूर्वक संग्रहीत किया गया।"
    override val replyListSnackbarRemoved = "आइटम स्थायी रूप से हटा दिया गया।"
    override val replyListSnackbarReopened = "आइटम फिर से खोला गया और रडार पर वापस आ गया।"
    override val replyListSnackbarResolved = "आइटम को हल के रूप में चिह्नित किया गया।"
    override val replyListSnackbarUnarchived = "आइटम सफलतापूर्वक असंग्रहीत किया गया।"
    override val replyListReminder = "अनुस्मारक"
    override val replyListReminderSet = "के लिए अनुस्मारक सेट करें:"
    override val replyListReminderSetSeparator = "%1 को %2 बजे"
    override val replyListReminderToday = "आज"
    override val replyListReminderTomorrow = "कल"
    override val replyListReminderTimeIconContentDescription = "समय"
    override val replyListReminderDateIconContentDescription = "दिनांक"
    override val replyListReminderCloseIconContentDescription = "बंद करें"
    override val replyListReminderInvalidDateTime = "चयनित दिनांक और समय पहले ही बीत चुका है।"
    override val replyListReminderTimePickerTitle = "समय चुनें"
    override val replyListReminderTimePickerConfirmButton = "ठीक है"
    override val replyListReminderTimePickerDismissButton = "रद्द करें"
    override val replyListReminderDatePickerConfirmButton = "ठीक है"
    override val replyListReminderDatePickerDismissButton = "रद्द करें"

    override val settingsTitle = "सेटिंग्स"
    override val settingsBackButton = "वापस"
    override val settingsTheme = "थीम"
    override val settingsThemeLight = "लाइट"
    override val settingsThemeDark = "डार्क"
    override val settingsThemeSystem = "सिस्टम डिफ़ॉल्ट का उपयोग करें"
    override val settingsLanguage = "भाषा"
    override val settingsLanguageEnglish = "अंग्रेज़ी"
    override val settingsLanguagePortuguese = "पुर्तगाली"
    override val settingsLanguageGerman = "जर्मन"
    override val settingsLanguageFrench = "फ्रेंच"
    override val settingsLanguageSpanish = "स्पेनिश"
    override val settingsLanguageSystem = "सिस्टम डिफ़ॉल्ट का उपयोग करें"
    override val settingsFeedbackTitle = "प्रतिक्रिया"
    override val settingsFeedbackDescription =
        "प्रश्नों, सुझावों या किसी बग की रिपोर्ट करने के लिए हमें एक ईमेल भेजें। आपकी प्रतिक्रिया Reply Radar को बेहतर बनाने में मदद करती है!"
    override val settingsFeedbackEmailSubject = "Reply Radar - प्रतिक्रिया और सुझाव"
    override val settingsFeedbackEmailBody = """
नमस्ते!

अपने प्रश्न, सुझाव साझा करने या किसी बग की रिपोर्ट करने के लिए स्वतंत्र महसूस करें।

सभी प्रतिक्रियाओं का बहुत स्वागत है :)

---

ऐप संस्करण: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "ऐप को रेट करें"
    override val settingsRateDescription =
        "Reply Radar का आनंद ले रहे हैं? Play Store पर एक समीक्षा छोड़ें और दूसरों को ऐप खोजने में मदद करें!"
    override val settingsAppVersion = "Reply Radar - संस्करण:"

    override val activityLogTitle = "गतिविधि लॉग"
    override val activityLogBackButton = "वापस"
    override val activityLogItemContentDescription = "गतिविधि लॉग आइटम"
    override val activityLogPlaceholder =
        "अभी तक कोई गतिविधि नहीं!\nआपका रडार कुछ कार्रवाई की प्रतीक्षा कर रहा है।"
    override val activityLogGetActivityLogsError =
        "आपकी गतिविधि लॉग लोड करने में विफल। कृपया पुन: प्रयास करें।"
    override val activityLogMessageFormat = "आपने %1 %2"
    override val activityLogMessageItem = "आइटम \"%1\"।"
    override val activityLogMessageItemRemoved = "एक आइटम जो अब मौजूद नहीं है।"
    override val activityLogUserActionArchiveVerb = "संग्रहीत"
    override val activityLogUserActionCreateVerb = "बनाया"
    override val activityLogUserActionDeleteVerb = "हटाया"
    override val activityLogUserActionEditVerb = "संपादित"
    override val activityLogUserActionReopenVerb = "फिर से खोला"
    override val activityLogUserActionResolveVerb = "हल किया"
    override val activityLogUserActionUnarchiveVerb = "असंग्रहीत"
    override val activityLogUserActionOpenVerb = "खोला"
    override val activityLogUserActionScheduledVerb = "के लिए एक अनुस्मारक निर्धारित किया"
    override val activityLogUserActionOpenedNotificationVerb = "के लिए एक अधिसूचना खोली"
    override val activityLogUserActionTheme = "आपने ऐप की थीम बदल दी।"
    override val activityLogUserActionLanguage = "आपने ऐप की भाषा बदल दी।"
    override val activityLogUserActionFeedback = "आपने ऐप के बारे में प्रतिक्रिया दी।"
    override val activityLogUserActionRate = "आपने ऐप को रेट किया।"

    override val notificationPermissionDialogTitle = "अधिसूचना अनुमति"
    override val notificationPermissionDialogDescription = "आपको अपने संदेशों का उत्तर देने के लिए याद दिलाने के लिए, हमें सूचनाएं भेजने की अनुमति चाहिए। \n\nआप इसे ऐप सेटिंग्स में सक्षम कर सकते हैं।"
    override val notificationPermissionDialogConfirmButton = "सेटिंग्स खोलें"
    override val notificationPermissionDialogDismissButton = "समझ गया"
    override val notificationTitle = "अरे, %1 को जवाब देने के बारे में क्या ख़याल है?"
    override val notificationContent = "%1 \"%2\" के बारे में आपके जवाब का इंतज़ार कर रहा है।"
    override val notificationContentWithoutSubject = "%1 आपके जवाब का इंतज़ार कर रहा है।"
}
// ktlint-enable max-line-length
