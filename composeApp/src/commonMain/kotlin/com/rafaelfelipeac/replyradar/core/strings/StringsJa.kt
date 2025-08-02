@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsJa : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "予期せぬエラーが発生しました。"

    override val replyListActivityLog = "アクティビティログ"
    override val replyListTabOnTheRadar = "レーダー上"
    override val replyListTabResolved = "解決済み"
    override val replyListTabArchived = "アーカイブ済み"
    override val replyListPlaceholderOnTheRadar =
        "現在、レーダーには何もありません！\n何か追加しませんか？"
    override val replyListGetRepliesError = "返信を読み込めませんでした。もう一度お試しください。"
    override val replyListPlaceholderResolved =
        "まだ解決済みの返信はありません。\n何かをやり遂げる時間ですか？"
    override val replyListPlaceholderArchived =
        "アーカイブは空のようです！\nレーダーをクリアする時間ですか？"
    override val replyListBottomSheetName = "名前"
    override val replyListBottomSheetSubject = "件名"
    override val replyListBottomSheetAdd = "追加"
    override val replyListBottomSheetSave = "保存"
    override val replyListBottomSheetResolve = "解決"
    override val replyListBottomSheetReopen = "再開"
    override val replyListBottomSheetArchive = "アーカイブ"
    override val replyListBottomSheetUnarchive = "アーカイブ解除"
    override val replyListBottomSheetDelete = "削除"
    override val replyListItemResolve = "解決"
    override val replyListItemCreatedAt = "作成日時: %1"
    override val replyListItemUpdatedAt = "更新日時: %1"
    override val replyListItemResolvedAt = "解決日時: %1"
    override val replyListItemArchivedAt = "アーカイブ日時: %1"
    override val replyListFabContentDescription = "レーダーに新しい返信を追加します。"
    override val replyListDeleteDialogTitle = "よろしいですか？"
    override val replyListDeleteDialogDescription = "この操作は「%1」を完全に削除し、元に戻すことはできません。"
    override val replyListDeleteDialogConfirm = "削除"
    override val replyListDeleteDialogDismiss = "キャンセル"
    override val replyListSnackbarArchived = "アイテムは正常にアーカイブされました。"
    override val replyListSnackbarRemoved = "アイテムは完全に削除されました。"
    override val replyListSnackbarReopened = "アイテムが再開され、レーダーに戻りました。"
    override val replyListSnackbarResolved = "アイテムは解決済みとしてマークされました。"
    override val replyListSnackbarUnarchived = "アイテムは正常にアーカイブ解除されました。"
    override val replyListReminder = "リマインダー"
    override val replyListReminderSet = "リマインダー設定:"
    override val replyListReminderSetSeparator = "%1 %2"
    override val replyListReminderToday = "今日"
    override val replyListReminderTomorrow = "明日"
    override val replyListReminderTimeIconContentDescription = "時間"
    override val replyListReminderDateIconContentDescription = "日付"
    override val replyListReminderCloseIconContentDescription = "閉じる"
    override val replyListReminderInvalidDateTime = "選択した日時が既に過ぎています。"
    override val replyListReminderTimePickerTitle = "時間を選択"
    override val replyListReminderTimePickerConfirmButton = "OK"
    override val replyListReminderTimePickerDismissButton = "キャンセル"
    override val replyListReminderDatePickerConfirmButton = "OK"
    override val replyListReminderDatePickerDismissButton = "キャンセル"

    override val settingsTitle = "設定"
    override val settingsBackButton = "戻る"
    override val settingsTheme = "テーマ"
    override val settingsThemeLight = "ライト"
    override val settingsThemeDark = "ダーク"
    override val settingsThemeSystem = "システムデフォルトを使用"
    override val settingsLanguage = "言語"
    override val settingsLanguageEnglish = "英語"
    override val settingsLanguagePortuguese = "ポルトガル語"
    override val settingsLanguageGerman = "ドイツ語"
    override val settingsLanguageFrench = "フランス語"
    override val settingsLanguageSpanish = "スペイン語"
    override val settingsLanguageSystem = "システムデフォルトを使用"
    override val settingsFeedbackTitle = "フィードバック"
    override val settingsFeedbackDescription =
        "質問、提案、またはバグの報告はメールでお送りください。あなたのフィードバックはReply Radarの改善に役立ちます！"
    override val settingsFeedbackEmailSubject = "Reply Radar - フィードバックと提案"
    override val settingsFeedbackEmailBody = """
こんにちは！

質問、提案、またはバグの報告を自由にお寄せください。

すべてのフィードバックを歓迎します:)

---

アプリのバージョン: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "アプリを評価"
    override val settingsRateDescription =
        "Reply Radarを楽しんでいますか？Playストアにレビューを残して、他の人がアプリを見つけるのを手伝ってください！"
    override val settingsAppVersion = "Reply Radar - バージョン:"

    override val activityLogTitle = "アクティビティログ"
    override val activityLogBackButton = "戻る"
    override val activityLogItemContentDescription = "アクティビティログアイテム"
    override val activityLogPlaceholder =
        "まだアクティビティはありません！\nレーダーが何かのアクションを待っています。"
    override val activityLogGetActivityLogsError =
        "アクティビティログを読み込めませんでした。もう一度お試しください。"
    override val activityLogMessageFormat = "あなたは%1 %2"
    override val activityLogMessageItem = "アイテム「%1」を。"
    override val activityLogMessageItemRemoved = "存在しなくなったアイテムを。"
    override val activityLogUserActionArchiveVerb = "アーカイブしました"
    override val activityLogUserActionCreateVerb = "作成しました"
    override val activityLogUserActionDeleteVerb = "削除しました"
    override val activityLogUserActionEditVerb = "編集しました"
    override val activityLogUserActionReopenVerb = "再開しました"
    override val activityLogUserActionResolveVerb = "解決しました"
    override val activityLogUserActionUnarchiveVerb = "アーカイブ解除しました"
    override val activityLogUserActionOpenVerb = "開きました"
    override val activityLogUserActionScheduledVerb = "リマインダーをスケジュールしました"
    override val activityLogUserActionOpenedNotificationVerb = "通知を開きました"
    override val activityLogUserActionTheme = "アプリのテーマを切り替えました。"
    override val activityLogUserActionLanguage = "アプリの言語を変更しました。"
    override val activityLogUserActionFeedback = "アプリに関するフィードバックを送信しました。"
    override val activityLogUserActionRate = "アプリを評価しました。"

    override val notificationPermissionDialogTitle = "通知の許可"
    override val notificationPermissionDialogDescription = "メッセージへの返信をリマインドするために、通知を送信する許可が必要です。\n\nアプリの設定で有効にできます。"
    override val notificationPermissionDialogConfirmButton = "設定を開く"
    override val notificationPermissionDialogDismissButton = "了解"
    override val notificationTitle = "こんにちは、%1に返信しませんか？"
    override val notificationContent = "%1が「%2」に関する返信を待っています。"
    override val notificationContentWithoutSubject = "%1が返信を待っています。"
}
// ktlint-enable max-line-length
