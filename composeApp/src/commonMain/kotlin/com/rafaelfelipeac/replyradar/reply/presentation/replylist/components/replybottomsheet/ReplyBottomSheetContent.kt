package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.platform.ui.DesertWhite
import com.rafaelfelipeac.replyradar.platform.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.platform.ui.components.ReplyTextField
import com.rafaelfelipeac.replyradar.platform.ui.paddingMedium
import com.rafaelfelipeac.replyradar.platform.ui.paddingSmall
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT
import org.jetbrains.compose.resources.stringResource
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_add
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_add_reply
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_delete
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_edit_reply
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_name
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_reopen
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_resolve
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_save
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_subject

private const val WEIGHT = 1f

@Composable
fun ReplyBottomSheetContent(
    replyBottomSheetState: ReplyBottomSheetState? = null,
    onComplete: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    replyBottomSheetState?.let { state ->
        var name by remember { mutableStateOf(state.reply?.name ?: EMPTY) }
        var subject by remember { mutableStateOf(state.reply?.subject ?: EMPTY) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(DesertWhite)
                .padding(paddingMedium),
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(bottom = paddingMedium),
                text = stringResource(if (state.replyBottomSheetMode == CREATE) string.reply_list_bottom_sheet_add_reply else string.reply_list_bottom_sheet_edit_reply),
                style = MaterialTheme.typography.headlineSmall
            )

            ReplyTextField(
                placeholder = name,
                label = stringResource(string.reply_list_bottom_sheet_name),
                onValueChange = { name = it }
            )

            ReplyTextField(
                placeholder = subject,
                label = stringResource(string.reply_list_bottom_sheet_subject),
                onValueChange = { subject = it }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = End
            ) {
                state.reply?.let {
                    if (state.replyBottomSheetMode == EDIT) {
                        ReplyButton(
                            modifier = Modifier.weight(WEIGHT)
                                .padding(end = paddingSmall),
                            text = stringResource(string.reply_list_bottom_sheet_delete),
                            onClick = { onDelete(state.reply) }
                        )

                        ReplyButton(
                            modifier = Modifier.weight(WEIGHT)
                                .padding(start = paddingSmall, end = paddingSmall),
                            text = stringResource(if (state.reply.isResolved) string.reply_list_bottom_sheet_reopen else string.reply_list_bottom_sheet_resolve),
                            onClick = { onResolve(state.reply) }
                        )
                    }
                }

                ReplyButton(
                    modifier = if (state.replyBottomSheetMode == EDIT) {
                        Modifier.weight(WEIGHT)
                            .padding(start = paddingSmall)
                    } else {
                        Modifier.wrapContentWidth()
                    },
                    text = stringResource(if (state.reply == null) string.reply_list_bottom_sheet_add else string.reply_list_bottom_sheet_save),
                    onClick = {
                        if (state.reply != null) {
                            onComplete(
                                state.reply.copy(
                                    name = name,
                                    subject = subject
                                )
                            )
                        } else {
                            onComplete(
                                Reply(
                                    name = name,
                                    subject = subject
                                )
                            )
                        }
                    },
                    enabled = name.isNotBlank()
                )
            }
        }
    }
}
