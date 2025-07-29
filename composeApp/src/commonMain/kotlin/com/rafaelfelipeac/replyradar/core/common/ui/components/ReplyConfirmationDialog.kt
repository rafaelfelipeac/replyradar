package com.rafaelfelipeac.replyradar.core.common.ui.components

import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.rafaelfelipeac.replyradar.core.common.ui.cardCornerRadius
import com.rafaelfelipeac.replyradar.core.common.ui.dialogElevation
import com.rafaelfelipeac.replyradar.core.common.ui.paddingLarge
import com.rafaelfelipeac.replyradar.core.common.ui.spacerLarge
import com.rafaelfelipeac.replyradar.core.common.ui.spacerSmall
import com.rafaelfelipeac.replyradar.core.theme.ReplyRadarTheme

@Composable
fun ReplyConfirmationDialog(
    title: String,
    description: String,
    confirm: String,
    dismiss: String,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(cardCornerRadius),
            color = colorScheme.surface,
            tonalElevation = dialogElevation
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingLarge)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = typography.titleLarge
                )

                Spacer(
                    modifier = Modifier
                        .height(spacerSmall)
                )

                Text(
                    text = description,
                    style = typography.bodyMedium,
                    color = colorScheme.onSurfaceVariant
                )

                Spacer(
                    modifier = Modifier
                        .height(spacerLarge)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = End
                ) {
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text(dismiss)
                    }

                    Spacer(
                        modifier = Modifier
                            .width(spacerSmall)
                    )

                    TextButton(
                        onClick = {
                            onConfirm()
                            onDismiss()
                        }
                    ) {
                        Text(confirm)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ReplyConfirmationDialogPreview() {
    ReplyRadarTheme {
        ReplyConfirmationDialog(
            title = "Title",
            description = "Description",
            confirm = "Confirm",
            dismiss = "Dismiss",
            onDismiss = {},
            onConfirm = {}
        )
    }
}
