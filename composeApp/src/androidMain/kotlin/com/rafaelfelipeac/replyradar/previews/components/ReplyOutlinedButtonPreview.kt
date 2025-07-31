package com.rafaelfelipeac.replyradar.previews.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafaelfelipeac.replyradar.core.common.ui.components.ReplyOutlinedButton
import com.rafaelfelipeac.replyradar.previews.shared.fakes.PreviewStringsFake
import com.rafaelfelipeac.replyradar.previews.shared.ReplyRadarPreviewWrapper
import replyradar.composeapp.generated.resources.Res
import replyradar.composeapp.generated.resources.ic_archive
import replyradar.composeapp.generated.resources.ic_check
import replyradar.composeapp.generated.resources.ic_delete
import replyradar.composeapp.generated.resources.ic_reopen
import replyradar.composeapp.generated.resources.ic_unarchive

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonActiveStatePreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetResolve,
                icon = Res.drawable.ic_check,
                onClick = {}
            )

            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetArchive,
                icon = Res.drawable.ic_archive,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonResolvedStatePreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetReopen,
                icon = Res.drawable.ic_reopen,
                onClick = {}
            )

            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetArchive,
                icon = Res.drawable.ic_archive,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonArchivedStatePreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = false
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetUnarchive,
                icon = Res.drawable.ic_unarchive,
                onClick = {}
            )

            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetDelete,
                icon = Res.drawable.ic_delete,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonActiveStateDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetResolve,
                icon = Res.drawable.ic_check,
                onClick = {}
            )

            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetArchive,
                icon = Res.drawable.ic_archive,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonResolvedStateDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetReopen,
                icon = Res.drawable.ic_reopen,
                onClick = {}
            )

            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetArchive,
                icon = Res.drawable.ic_archive,
                onClick = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReplyOutlinedButtonArchivedStateDarkPreview() {
    ReplyRadarPreviewWrapper(
        darkTheme = true
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .padding(8.dp)
        ) {
            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetUnarchive,
                icon = Res.drawable.ic_unarchive,
                onClick = {}
            )

            ReplyOutlinedButton(
                text = PreviewStringsFake.replyListBottomSheetDelete,
                icon = Res.drawable.ic_delete,
                onClick = {}
            )
        }
    }
}
