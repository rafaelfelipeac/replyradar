package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyReminder
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextField
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextFieldSize.Large
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.core.datetime.dateTime
import com.rafaelfelipeac.replyradar.core.strings.LocalReplyRadarStrings
import com.rafaelfelipeac.replyradar.core.util.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.core.util.AppConstants.INITIAL_DATE
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.ReplyTimestampInfo

@Composable
fun ReplyBottomSheetContent(
    replyBottomSheetState: ReplyBottomSheetState? = null,
    onSave: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit,
    onInvalidReminderValue: () -> Unit
) {
    replyBottomSheetState?.let { state ->
        var name by remember { mutableStateOf(state.reply?.name ?: EMPTY) }
        var subject by remember { mutableStateOf(state.reply?.subject ?: EMPTY) }
        val reminderAt = state.reply?.reminderAt?.takeIf { it != INITIAL_DATE }?.dateTime()
        var selectedTime by remember(reminderAt) { mutableStateOf(reminderAt?.time) }
        var selectedDate by remember(reminderAt) { mutableStateOf(reminderAt?.date) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorScheme.background)
                .padding(start = paddingMedium, top = paddingMedium, end = paddingMedium),
            horizontalAlignment = CenterHorizontally
        ) {
            val focusRequester = remember { FocusRequester() }
            val keyboardController = LocalSoftwareKeyboardController.current

            LaunchedEffect(Unit) {
                focusRequester.requestFocus()
                keyboardController?.show()
            }

            ReplyTextField(
                modifier = Modifier
                    .padding(top = paddingSmall)
                    .focusRequester(focusRequester),
                value = name,
                placeholder = LocalReplyRadarStrings.current.replyListBottomSheetName,
                onValueChange = { name = it },
                textSize = Large
            )

            ReplyTextField(
                value = subject,
                placeholder = LocalReplyRadarStrings.current.replyListBottomSheetSubject,
                onValueChange = { subject = it }
            )

            ReplyReminder(
                selectedTime = selectedTime,
                selectedDate = selectedDate,
                onSelectedTimeChange = { selectedTime = it },
                onSelectedDateChange = { selectedDate = it },
                closeKeyboard = { keyboardController?.hide() }
            )

            ReplyTimestampInfo(state)

            ReplyBottomSheetActions(
                state = replyBottomSheetState,
                onArchive = onArchive,
                onResolve = onResolve,
                onDelete = onDelete,
                onSave = onSave,
                onInvalidReminderValue = { onInvalidReminderValue() },
                selectedDate = selectedDate,
                selectedTime = selectedTime,
                reply = state.reply,
                name = name,
                subject = subject
            )
        }
    }
}
