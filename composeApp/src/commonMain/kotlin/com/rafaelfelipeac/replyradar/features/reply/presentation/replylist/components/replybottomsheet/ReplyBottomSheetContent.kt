package com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.rafaelfelipeac.replyradar.core.AppConstants.EMPTY
import com.rafaelfelipeac.replyradar.core.common.ui.SlightBlueGrey
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyButton
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyTextField
import com.rafaelfelipeac.replyradar.core.common.ui.paddingMedium
import com.rafaelfelipeac.replyradar.core.common.ui.paddingSmall
import com.rafaelfelipeac.replyradar.features.reply.domain.model.Reply
import com.rafaelfelipeac.replyradar.features.reply.presentation.replylist.components.replybottomsheet.ReplyBottomSheetMode.EDIT
import org.jetbrains.compose.resources.stringResource
import replyradar.composeapp.generated.resources.Res.string
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_add
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_archive
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_delete
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_name
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_reopen
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_resolve
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_restore
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_save
import replyradar.composeapp.generated.resources.reply_list_bottom_sheet_subject

private const val WEIGHT = 1f

@Composable
fun ReplyBottomSheetContent(
    replyBottomSheetState: ReplyBottomSheetState? = null,
    onComplete: (Reply) -> Unit,
    onResolve: (Reply) -> Unit,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    replyBottomSheetState?.let { state ->
        var name by remember { mutableStateOf(state.reply?.name ?: EMPTY) }
        var subject by remember { mutableStateOf(state.reply?.subject ?: EMPTY) }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(SlightBlueGrey)
                .padding(horizontal = paddingMedium),
            horizontalAlignment = CenterHorizontally
        ) {
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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = paddingSmall),
                horizontalArrangement = if (isEditMode(state)) spacedBy(paddingSmall) else End
            ) {
                if (state.reply != null && isEditMode(state)) {
                    Column(
                        modifier = Modifier.weight(WEIGHT),
                        verticalArrangement = spacedBy(paddingSmall)
                    ) {
                        with(state.reply) {
                            when {
                                !isArchived && !isResolved -> {
                                    ActiveStateButtons(
                                        modifier = Modifier.fillMaxWidth(),
                                        reply = state.reply,
                                        onArchive = onArchive,
                                        onResolve = onResolve
                                    )
                                }

                                isResolved -> {
                                    ResolvedStateButtons(
                                        modifier = Modifier.fillMaxWidth(),
                                        reply = state.reply,
                                        onArchive = onArchive,
                                        onResolve = onResolve
                                    )
                                }

                                isArchived -> {
                                    ArchivedStateButton(
                                        modifier = Modifier.fillMaxWidth(),
                                        reply = state.reply,
                                        onArchive = onArchive,
                                        onDelete = onDelete
                                    )
                                }
                            }
                        }
                    }
                }

                ReplyButton(
                    modifier = if (isEditMode(state)) {
                        Modifier
                            .weight(WEIGHT)
                            .padding(start = paddingSmall)
                    } else {
                        Modifier.wrapContentWidth()
                    },
                    text = stringResource(
                        if (state.reply == null) {
                            string.reply_list_bottom_sheet_add
                        } else {
                            string.reply_list_bottom_sheet_save
                        }
                    ),
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

            Spacer(modifier = Modifier.height(paddingMedium))
        }
    }
}

private fun isEditMode(state: ReplyBottomSheetState) = state.replyBottomSheetMode == EDIT

@Composable
private fun ActiveStateButtons(
    modifier: Modifier = Modifier,
    reply: Reply,
    onArchive: (Reply) -> Unit,
    onResolve: (Reply) -> Unit
) {
    ReplyButton(
        modifier = modifier,
        text = stringResource(string.reply_list_bottom_sheet_resolve),
        onClick = { onResolve(reply) }
    )

    ReplyButton(
        modifier = modifier,
        text = stringResource(string.reply_list_bottom_sheet_archive),
        onClick = { onArchive(reply) }
    )
}

@Composable
private fun ResolvedStateButtons(
    modifier: Modifier = Modifier,
    reply: Reply,
    onArchive: (Reply) -> Unit,
    onResolve: (Reply) -> Unit
) {
    ReplyButton(
        modifier = modifier,
        text = stringResource(string.reply_list_bottom_sheet_reopen),
        onClick = { onResolve(reply) }
    )

    ReplyButton(
        modifier = modifier,
        text = stringResource(string.reply_list_bottom_sheet_archive),
        onClick = { onArchive(reply) }
    )
}

@Composable
private fun ArchivedStateButton(
    modifier: Modifier = Modifier,
    reply: Reply,
    onArchive: (Reply) -> Unit,
    onDelete: (Reply) -> Unit
) {
    ReplyButton(
        modifier = modifier,
        text = stringResource(string.reply_list_bottom_sheet_restore),
        onClick = { onArchive(reply) }
    )

    ReplyButton(
        modifier = modifier,
        text = stringResource(string.reply_list_bottom_sheet_delete),
        onClick = { onDelete(reply) }
    )
}
