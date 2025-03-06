package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.core.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.CREATE
import com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet.BottomSheetMode.EDIT
import org.jetbrains.compose.resources.stringResource
import replyradar.composeapp.generated.resources.Res
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_add_reply
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_save
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_edit_reply
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_name
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_add
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_delete
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_reopen
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_resolve
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_subject

@Composable
fun BottomSheetContent(
    mode: BottomSheetMode,
    reply: Reply?,
    onComplete: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    var name by remember { mutableStateOf(reply?.name ?: EMPTY) }
    var subject by remember { mutableStateOf(reply?.subject ?: EMPTY) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = stringResource(if (mode == CREATE) Res.string.reply_list_bottom_sheet_add_reply else Res.string.reply_list_bottom_sheet_edit_reply),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        TextField(
            value = name,
            singleLine = true,
            onValueChange = { name = it },
            label = { Text(stringResource(Res.string.reply_list_bottom_sheet_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        TextField(
            value = subject,
            singleLine = true,
            onValueChange = { subject = it },
            label = { Text(stringResource(Res.string.reply_list_bottom_sheet_subject)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            horizontalArrangement = End,
            modifier = Modifier.fillMaxWidth()
        ) {
            if (mode == EDIT) {
                Button(
                    modifier = Modifier.weight(1f)
                        .padding(end = 8.dp),
                    onClick = {
                        if (reply != null) {
                            onDelete(reply)
                        }
                    },
                    enabled = name.isNotBlank()
                ) {
                    Text(stringResource(Res.string.reply_list_bottom_sheet_delete))
                }

                Button(
                    modifier = Modifier.weight(1f)
                        .padding(start = 8.dp, end = 8.dp),
                    onClick = {
                        if (reply != null) {
                            onResolve(reply)
                        }
                    },
                    enabled = name.isNotBlank()
                ) {
                    Text(
                        if (reply != null && reply.isResolved) {
                            stringResource(Res.string.reply_list_bottom_sheet_reopen)
                        } else {
                            stringResource(Res.string.reply_list_bottom_sheet_resolve)
                        }
                    )
                }
            }

            Button(
                modifier = if (mode == EDIT) {
                    Modifier.weight(1f)
                        .padding(start = 8.dp)
                } else {
                    Modifier.wrapContentWidth()
                },
                onClick = {
                    if (reply != null) {
                        onComplete(
                            reply.copy(
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
            ) {
                Text(stringResource(if (reply == null) Res.string.reply_list_bottom_sheet_add else Res.string.reply_list_bottom_sheet_save))
            }
        }
    }
}
