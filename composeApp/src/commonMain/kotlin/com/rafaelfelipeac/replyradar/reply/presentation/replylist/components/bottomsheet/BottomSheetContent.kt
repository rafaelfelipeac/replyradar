package com.rafaelfelipeac.replyradar.reply.presentation.replylist.components.bottomsheet

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Arrangement.SpaceBetween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_edit
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_edit_reply
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_name
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_add

@Composable
fun BottomSheetContent(
    mode: BottomSheetMode,
    reply: Reply?,
    onComplete: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    var name by remember { mutableStateOf(reply?.title ?: EMPTY) }

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
            onValueChange = { name = it },
            label = { Text(stringResource(Res.string.reply_list_bottom_sheet_name)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Row(
            horizontalArrangement = End,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (reply != null) {
                        onComplete(
                            reply.copy(
                                title = name
                            )
                        )
                    } else {
                        onComplete(Reply(title = name))
                    }
                },
                enabled = name.isNotBlank()
            ) {
                Text(stringResource(if (reply == null) Res.string.reply_list_bottom_sheet_add else Res.string.reply_list_bottom_sheet_edit))
            }
        }

        if (mode == EDIT) {
            Row(
                horizontalArrangement = SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)
            ) {
                Button(
                    onClick = {
                        if (reply != null) {
                            onDelete(reply)
                        }
                    },
                    enabled = name.isNotBlank()
                ) {
                    Text("Delete")
                }

                Button(
                    onClick = {
                        if (reply != null) {
                            onResolve(reply)
                        }
                    },
                    enabled = name.isNotBlank()
                ) {
                    Text("Resolve")
                }
            }
        }
    }
}
