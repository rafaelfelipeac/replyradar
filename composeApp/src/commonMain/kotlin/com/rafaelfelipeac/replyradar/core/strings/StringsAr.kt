@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsAr : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "حدث خطأ غير متوقع."

    override val replyListActivityLog = "سجل النشاط"
    override val replyListTabOnTheRadar = "على الرادار"
    override val replyListTabResolved = "تم الحل"
    override val replyListTabArchived = "مؤرشف"
    override val replyListPlaceholderOnTheRadar =
        "لا يوجد شيء على الرادار الآن!\nماذا عن إضافة شيء ما؟"
    override val replyListGetRepliesError = "فشل تحميل ردودك. يرجى المحاولة مرة أخرى."
    override val replyListPlaceholderResolved =
        "لا توجد ردود محلولة حتى الآن.\nهل حان الوقت لإنجاز شيء ما؟"
    override val replyListPlaceholderArchived =
        "الأرشيف يبدو فارغًا!\nهل حان الوقت لتنظيف رادارك؟"
    override val replyListBottomSheetName = "الاسم"
    override val replyListBottomSheetSubject = "الموضوع"
    override val replyListBottomSheetAdd = "إضافة"
    override val replyListBottomSheetSave = "حفظ"
    override val replyListBottomSheetResolve = "حل"
    override val replyListBottomSheetReopen = "إعادة فتح"
    override val replyListBottomSheetArchive = "أرشفة"
    override val replyListBottomSheetUnarchive = "إلغاء الأرشفة"
    override val replyListBottomSheetDelete = "حذف"
    override val replyListItemResolve = "حل"
    override val replyListItemCreatedAt = "تم الإنشاء في: %1"
    override val replyListItemUpdatedAt = "تم التحديث في: %1"
    override val replyListItemResolvedAt = "تم الحل في: %1"
    override val replyListItemArchivedAt = "تمت الأرشفة في: %1"
    override val replyListFabContentDescription = "إضافة رد جديد إلى رادارك."
    override val replyListDeleteDialogTitle = "هل أنت متأكد؟"
    override val replyListDeleteDialogDescription = "سيؤدي هذا الإجراء إلى حذف \"%1\" نهائيًا ولا يمكن التراجع عنه."
    override val replyListDeleteDialogConfirm = "حذف"
    override val replyListDeleteDialogDismiss = "إلغاء"
    override val replyListSnackbarArchived = "تمت أرشفة العنصر بنجاح."
    override val replyListSnackbarRemoved = "تم حذف العنصر نهائيًا."
    override val replyListSnackbarReopened = "تمت إعادة فتح العنصر وعاد إلى الرادار."
    override val replyListSnackbarResolved = "تم وضع علامة على العنصر كمحلول."
    override val replyListSnackbarUnarchived = "تم إلغاء أرشفة العنصر بنجاح."
    override val replyListReminder = "تذكير"
    override val replyListReminderSet = "تم تعيين تذكير لـ:"
    override val replyListReminderSetSeparator = "%1 في %2"
    override val replyListReminderToday = "اليوم"
    override val replyListReminderTomorrow = "غدًا"
    override val replyListReminderTimeIconContentDescription = "الوقت"
    override val replyListReminderDateIconContentDescription = "التاريخ"
    override val replyListReminderCloseIconContentDescription = "إغلاق"
    override val replyListReminderInvalidDateTime = "لقد فات الأوان بالفعل على التاريخ والوقت المحددين."
    override val replyListReminderTimePickerTitle = "تحديد الوقت"
    override val replyListReminderTimePickerConfirmButton = "موافق"
    override val replyListReminderTimePickerDismissButton = "إلغاء"
    override val replyListReminderDatePickerConfirmButton = "موافق"
    override val replyListReminderDatePickerDismissButton = "إلغاء"

    override val settingsTitle = "الإعدادات"
    override val settingsBackButton = "رجوع"
    override val settingsTheme = "المظهر"
    override val settingsThemeLight = "فاتح"
    override val settingsThemeDark = "داكن"
    override val settingsThemeSystem = "استخدام إعدادات النظام الافتراضية"
    override val settingsLanguage = "اللغة"
    override val settingsLanguageEnglish = "الإنجليزية"
    override val settingsLanguagePortuguese = "البرتغالية"
    override val settingsLanguageGerman = "الألمانية"
    override val settingsLanguageFrench = "الفرنسية"
    override val settingsLanguageSpanish = "الإسبانية"
    override val settingsLanguageSystem = "استخدام إعدادات النظام الافتراضية"
    override val settingsFeedbackTitle = "ملاحظات"
    override val settingsFeedbackDescription =
        "أرسل لنا بريدًا إلكترونيًا بأسئلتك أو اقتراحاتك أو للإبلاغ عن خطأ. تساعدنا ملاحظاتك في تحسين Reply Radar!"
    override val settingsFeedbackEmailSubject = "Reply Radar - ملاحظات واقتراحات"
    override val settingsFeedbackEmailBody = """
مرحباً!

لا تتردد في مشاركة أسئلتك أو اقتراحاتك أو الإبلاغ عن خطأ.

نرحب بشدة بجميع الملاحظات :)

---

إصدار التطبيق: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "تقييم التطبيق"
    override val settingsRateDescription =
        "هل تستمتع بـ Reply Radar؟ اترك مراجعة على متجر Play وساعد الآخرين في اكتشاف التطبيق!"
    override val settingsAppVersion = "Reply Radar - الإصدار:"

    override val activityLogTitle = "سجل النشاط"
    override val activityLogBackButton = "رجوع"
    override val activityLogItemContentDescription = "عنصر سجل النشاط"
    override val activityLogPlaceholder =
        "لا يوجد نشاط حتى الآن!\nرادارك ينتظر بعض الإجراءات."
    override val activityLogGetActivityLogsError =
        "فشل تحميل سجل نشاطك. يرجى المحاولة مرة أخرى."
    override val activityLogMessageFormat = "لقد قمت بـ %1 %2"
    override val activityLogMessageItem = "العنصر \"%1\"."
    override val activityLogMessageItemRemoved = "عنصر لم يعد موجودًا."
    override val activityLogUserActionArchiveVerb = "أرشفة"
    override val activityLogUserActionCreateVerb = "إنشاء"
    override val activityLogUserActionDeleteVerb = "حذف"
    override val activityLogUserActionEditVerb = "تعديل"
    override val activityLogUserActionReopenVerb = "إعادة فتح"
    override val activityLogUserActionResolveVerb = "حل"
    override val activityLogUserActionUnarchiveVerb = "إلغاء أرشفة"
    override val activityLogUserActionOpenVerb = "فتح"
    override val activityLogUserActionScheduledVerb = "جدولة تذكير لـ"
    override val activityLogUserActionOpenedNotificationVerb = "فتح إشعار لـ"
    override val activityLogUserActionTheme = "لقد قمت بتبديل مظهر التطبيق."
    override val activityLogUserActionLanguage = "لقد قمت بتغيير لغة التطبيق."
    override val activityLogUserActionFeedback = "لقد قدمت ملاحظات حول التطبيق."
    override val activityLogUserActionRate = "لقد قمت بتقييم التطبيق."

    override val notificationPermissionDialogTitle = "إذن الإشعارات"
    override val notificationPermissionDialogDescription = "لتذكيرك بالرد على رسائلك، نحتاج إلى إذن لإرسال الإشعارات. \n\nيمكنك تمكينه في إعدادات التطبيق."
    override val notificationPermissionDialogConfirmButton = "فتح الإعدادات"
    override val notificationPermissionDialogDismissButton = "فهمت"
    override val notificationTitle = "مرحبًا، ما رأيك في الرد على %1؟"
    override val notificationContent = "%1 ينتظر ردك بخصوص \"%2\"."
    override val notificationContentWithoutSubject = "%1 ينتظر ردك."
}
// ktlint-enable max-line-length
