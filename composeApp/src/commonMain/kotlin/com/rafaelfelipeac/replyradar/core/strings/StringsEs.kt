@file:Suppress("MaxLineLength")

package com.rafaelfelipeac.replyradar.core.strings

import com.rafaelfelipeac.replyradar.core.version.getAppVersion

// ktlint-disable max-line-length
object StringsEs : Strings {
    override val appName = "Reply Radar"

    override val genericErrorMessage = "Ocurrió un error inesperado."

    override val replyListActivityLog = "Registro de actividad"
    override val replyListTabOnTheRadar = "En el radar"
    override val replyListTabResolved = "Resuelto"
    override val replyListTabArchived = "Archivado"
    override val replyListPlaceholderOnTheRadar =
        "¡Nada en el radar por ahora!\n¿Qué tal si agregas algo?"
    override val replyListGetRepliesError = "No se pudieron cargar tus respuestas. Inténtalo de nuevo."
    override val replyListPlaceholderResolved =
        "Aún no hay respuestas resueltas.\n¿Es hora de hacer algo?"
    override val replyListPlaceholderArchived =
        "¡El archivo se ve vacío!\n¿Es hora de limpiar tu radar?"
    override val replyListBottomSheetName = "Nombre"
    override val replyListBottomSheetSubject = "Asunto"
    override val replyListBottomSheetAdd = "Agregar"
    override val replyListBottomSheetSave = "Guardar"
    override val replyListBottomSheetResolve = "Resolver"
    override val replyListBottomSheetReopen = "Reabrir"
    override val replyListBottomSheetArchive = "Archivar"
    override val replyListBottomSheetUnarchive = "Desarchivar"
    override val replyListBottomSheetDelete = "Eliminar"
    override val replyListItemResolve = "Resolver"
    override val replyListItemCreatedAt = "Creado el: %1"
    override val replyListItemUpdatedAt = "Actualizado el: %1"
    override val replyListItemResolvedAt = "Resuelto el: %1"
    override val replyListItemArchivedAt = "Archivado el: %1"
    override val replyListFabContentDescription = "Agrega una nueva respuesta a tu radar."
    override val replyListDeleteDialogTitle = "¿Estás seguro?"
    override val replyListDeleteDialogDescription = "Esta acción eliminará permanentemente \"%1\" y no se puede deshacer."
    override val replyListDeleteDialogConfirm = "Eliminar"
    override val replyListDeleteDialogDismiss = "Cancelar"
    override val replyListSnackbarArchived = "Elemento archivado con éxito."
    override val replyListSnackbarRemoved = "Elemento eliminado permanentemente."
    override val replyListSnackbarReopened = "Elemento reabierto y de vuelta en el radar."
    override val replyListSnackbarResolved = "Elemento marcado como resuelto."
    override val replyListSnackbarUnarchived = "Elemento desarchivado con éxito."
    override val replyListReminder = "Recordatorio"
    override val replyListReminderSet = "Recordatorio establecido para:"
    override val replyListReminderSetSeparator = "%1 a las %2"
    override val replyListReminderToday = "hoy"
    override val replyListReminderTomorrow = "mañana"
    override val replyListReminderTimeIconContentDescription = "Hora"
    override val replyListReminderDateIconContentDescription = "Fecha"
    override val replyListReminderCloseIconContentDescription = "Cerrar"
    override val replyListReminderInvalidDateTime = "La fecha y hora seleccionadas ya pasaron."
    override val replyListReminderTimePickerTitle = "Seleccionar hora"
    override val replyListReminderTimePickerConfirmButton = "Aceptar"
    override val replyListReminderTimePickerDismissButton = "Cancelar"
    override val replyListReminderDatePickerConfirmButton = "Aceptar"
    override val replyListReminderDatePickerDismissButton = "Cancelar"

    override val settingsTitle = "Configuración"
    override val settingsBackButton = "Atrás"
    override val settingsTheme = "Tema"
    override val settingsThemeLight = "Claro"
    override val settingsThemeDark = "Oscuro"
    override val settingsThemeSystem = "Usar predeterminado del sistema"
    override val settingsLanguage = "Idioma"
    override val settingsLanguageEnglish = "Inglés"
    override val settingsLanguagePortuguese = "Portugués"
    override val settingsLanguageGerman = "Alemán"
    override val settingsLanguageFrench = "Francés"
    override val settingsLanguageSpanish = "Español"
    override val settingsLanguageSystem = "Usar predeterminado del sistema"
    override val settingsFeedbackTitle = "Comentarios"
    override val settingsFeedbackDescription =
        "Envíanos un correo electrónico con preguntas, sugerencias o para informar un error. ¡Tus comentarios ayudan a mejorar Reply Radar!"
    override val settingsFeedbackEmailSubject = "Reply Radar - Comentarios y Sugerencias"
    override val settingsFeedbackEmailBody = """
¡Hola!

No dudes en compartir tus preguntas, sugerencias o informar un error.

Todos los comentarios son muy bienvenidos :)

---

Versión de la aplicación: ${getAppVersion()}
    """.trimIndent()
    override val settingsRateTitle = "Calificar la aplicación"
    override val settingsRateDescription =
        "¿Disfrutas de Reply Radar? ¡Deja una reseña en Play Store y ayuda a otros a descubrir la aplicación!"
    override val settingsAppVersion = "Reply Radar - Versión:"

    override val activityLogTitle = "Registro de actividad"
    override val activityLogBackButton = "Atrás"
    override val activityLogItemContentDescription = "Elemento del registro de actividad"
    override val activityLogPlaceholder =
        "¡Aún no hay actividad!\nTu radar está esperando acción."
    override val activityLogGetActivityLogsError =
        "No se pudo cargar tu registro de actividad. Inténtalo de nuevo."
    override val activityLogMessageFormat = "Has %1 %2"
    override val activityLogMessageItem = "el elemento \"%1\"."
    override val activityLogMessageItemRemoved = "un elemento que ya no existe."
    override val activityLogUserActionArchiveVerb = "archivado"
    override val activityLogUserActionCreateVerb = "creado"
    override val activityLogUserActionDeleteVerb = "eliminado"
    override val activityLogUserActionEditVerb = "editado"
    override val activityLogUserActionReopenVerb = "reabierto"
    override val activityLogUserActionResolveVerb = "resuelto"
    override val activityLogUserActionUnarchiveVerb = "desarchivado"
    override val activityLogUserActionOpenVerb = "abierto"
    override val activityLogUserActionScheduledVerb = "programado un recordatorio para"
    override val activityLogUserActionOpenedNotificationVerb = "abierto una notificación para"
    override val activityLogUserActionTheme = "Cambiaste el tema de la aplicación."
    override val activityLogUserActionLanguage = "Cambiaste el idioma de la aplicación."
    override val activityLogUserActionFeedback = "Diste tu opinión sobre la aplicación."
    override val activityLogUserActionRate = "Calificaste la aplicación."

    override val notificationPermissionDialogTitle = "Permiso de notificación"
    override val notificationPermissionDialogDescription = "Para recordarte que respondas a tus mensajes, necesitamos permiso para enviar notificaciones. \n\nPuedes habilitarlo en la configuración de la aplicación."
    override val notificationPermissionDialogConfirmButton = "Abrir configuración"
    override val notificationPermissionDialogDismissButton = "Entendido"
    override val notificationTitle = "¿Qué tal si le respondes a %1?"
    override val notificationContent = "%1 está esperando tu respuesta sobre \"%2\"."
    override val notificationContentWithoutSubject = "%1 está esperando tu respuesta."
}
// ktlint-enable max-line-length
