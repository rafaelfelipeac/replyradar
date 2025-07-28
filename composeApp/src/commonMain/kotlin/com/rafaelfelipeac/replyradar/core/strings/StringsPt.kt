@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsPt : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "Ocorreu um erro inesperado."

    override val replyListActivityLog = "Atividades"
    override val replyListTabOnTheRadar = "No Radar"
    override val replyListTabResolved = "Resolvidos"
    override val replyListTabArchived = "Arquivados"
    override val replyListPlaceholderOnTheRadar =
        "Nada no radar por enquanto!\nQue tal adicionar algo?"
    override val replyListGetRepliesError =
        "Não foi possível carregar suas mensagens. Tente novamente."
    override val replyListPlaceholderResolved =
        "Nenhuma resposta resolvida ainda.\nHora de resolver alguma coisa?"
    override val replyListPlaceholderArchived = "O arquivo está vazio!\nHora de limpar seu radar?"
    override val replyListBottomSheetName = "Nome"
    override val replyListBottomSheetSubject = "Assunto"
    override val replyListBottomSheetAdd = "Adicionar"
    override val replyListBottomSheetSave = "Salvar"
    override val replyListBottomSheetResolve = "Resolver"
    override val replyListBottomSheetReopen = "Reabrir"
    override val replyListBottomSheetArchive = "Arquivar"
    override val replyListBottomSheetUnarchive = "Desarquivar"
    override val replyListBottomSheetDelete = "Excluir"
    override val replyListItemResolve = "Resolver"
    override val replyListItemCreatedAt = "Criado em: %1"
    override val replyListItemUpdatedAt = "Atualizado em: %1"
    override val replyListItemResolvedAt = "Resolvido em: %1"
    override val replyListItemArchivedAt = "Arquivado em: %1"
    override val replyListFabContentDescription = "Adicione uma nova mensagem ao seu radar."
    override val replyListDeleteDialogTitle = "Tem certeza?"
    override val replyListDeleteDialogDescription = "Essa ação vai deletar permanentemente \"%1\" e não pode ser desfeita."
    override val replyListDeleteDialogConfirm = "Deletar"
    override val replyListDeleteDialogDismiss = "Cancelar"
    override val replyListSnackbarArchived = "Item arquivado com sucesso."
    override val replyListSnackbarRemoved = "Item deletado permanentemente."
    override val replyListSnackbarReopened = "Item reaberto e voltou para o radar."
    override val replyListSnackbarResolved = "Item marcado como resolvido."
    override val replyListSnackbarUnarchived = "Item desarquivado com sucesso."
    override val replyListReminder = "Lembrete"
    override val replyListReminderSet = "Lembrete definido para:"
    override val replyListReminderSetSeparator = "%1 às %2"
    override val replyListReminderToday = "hoje"
    override val replyListReminderTomorrow = "amanhã"
    override val replyListReminderTimeIconContentDescription = "Horário"
    override val replyListReminderDateIconContentDescription = "Data"
    override val replyListReminderCloseIconContentDescription = "Remover"
    override val replyListReminderInvalidDateTime = "A data e hora selecionadas já passaram."
    override val replyListReminderTimePickerTitle = "Selecionar horário"
    override val replyListReminderTimePickerConfirmButton = "OK"
    override val replyListReminderTimePickerDismissButton = "Cancelar"
    override val replyListReminderDatePickerConfirmButton = "OK"
    override val replyListReminderDatePickerDismissButton = "Cancelar"

    override val settingsTitle = "Configurações"
    override val settingsBackButton = "Voltar"
    override val settingsTheme = "Tema"
    override val settingsThemeLight = "Claro"
    override val settingsThemeDark = "Escuro"
    override val settingsThemeSystem = "Usar padrão do sistema"
    override val settingsLanguage = "Idioma"
    override val settingsLanguageEnglish = "Inglês"
    override val settingsLanguagePortuguese = "Português"
    override val settingsLanguageSystem = "Usar padrão do sistema"
    override val settingsFeedbackTitle = "Feedback"
    override val settingsFeedbackDescription =
        "Nos envie um e-mail com dúvidas, sugestões ou para relatar um problema. Seu feedback ajuda a melhorar o Reply Radar!"
    override val settingsFeedbackEmailSubject = "Reply Radar - Feedback e Sugestões"
    override val settingsFeedbackEmailBody = """
Olá!

Escreva aqui suas dúvidas, sugestões ou relatos de bugs. 

Qualquer feedback é muito bem-vindo :)

---

Versão do app: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "Avalie o app"
    override val settingsRateDescription =
        "Curtiu o Reply Radar? Deixe uma avaliação na Play Store e ajude mais pessoas a descobrirem o app!"
    override val settingsAppVersion = "Reply Radar - Versão:"

    override val activityLogTitle = "Registro de atividades"
    override val activityLogBackButton = "Voltar"
    override val activityLogItemContentDescription = "Item de registro de atividades"
    override val activityLogPlaceholder =
        "Nenhuma atividade por enquanto!\nSeu radar está esperando por ação."
    override val activityLogGetActivityLogsError =
        "Não foi possível carregar seu histórico de atividades. Tente novamente."
    override val activityLogMessageFormat = "Você %1 %2"
    override val activityLogMessageItem = "o item \"%1\"."
    override val activityLogMessageItemRemoved = "um item que já não existe mais."
    override val activityLogUserActionArchiveVerb = "arquivou"
    override val activityLogUserActionCreateVerb = "criou"
    override val activityLogUserActionDeleteVerb = "removeu"
    override val activityLogUserActionEditVerb = "editou"
    override val activityLogUserActionReopenVerb = "reabriu"
    override val activityLogUserActionResolveVerb = "resolveu"
    override val activityLogUserActionUnarchiveVerb = "desarquivou"
    override val activityLogUserActionOpenVerb = "abriu"
    override val activityLogUserActionScheduledVerb = "agendou um lembrete para"
    override val activityLogUserActionOpenedNotificationVerb = "abriu uma notificação para"
    override val activityLogUserActionTheme = "Você mudou o tema do app."
    override val activityLogUserActionLanguage = "Você mudou o idioma do app."
    override val activityLogUserActionFeedback = "Você enviou um feedback sobre o app."
    override val activityLogUserActionRate = "Você avaliou o app."

    override val notificationPermissionDialogTitle = "Permissão de notificações"
    override val notificationPermissionDialogDescription = "Para que possamos te lembrar de responder às suas mensagens, precisamos que você permita o envio de notificações. \n\nVocê pode ativar isso nas configurações do app."
    override val notificationPermissionDialogConfirmButton = "Abrir Configurações"
    override val notificationPermissionDialogDismissButton = "Entendido"
    override val notificationTitle = "Hey, que tal responder %1?"
    override val notificationContent = "%1 está esperando sua resposta sobre \"%2\"."
    override val notificationContentWithoutSubject = "%1 está esperando sua resposta."
}
// ktlint-enable max-line-length
