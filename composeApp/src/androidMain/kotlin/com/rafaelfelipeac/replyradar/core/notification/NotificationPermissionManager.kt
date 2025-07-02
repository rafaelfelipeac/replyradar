package com.rafaelfelipeac.replyradar.core.notification

import android.Manifest.permission.POST_NOTIFICATIONS
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.TIRAMISU
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.checkSelfPermission
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

private const val PACKAGE = "package"

@Composable
fun rememberNotificationPermissionManager(): NotificationPermissionManager {
    val context = LocalContext.current
    val permissionResultState = remember { mutableStateOf<Boolean?>(null) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        permissionResultState.value = isGranted
    }

    return remember {
        object : NotificationPermissionManager {

            override suspend fun ensureNotificationPermission(): Boolean {
                if (SDK_INT < TIRAMISU) {
                    return true
                }

                val granted = checkSelfPermission(context, POST_NOTIFICATIONS) == PERMISSION_GRANTED

                if (granted) {
                    return true
                }

                return suspendCancellableCoroutine { permissionContinuation ->
                    permissionResultState.value = null
                    permissionLauncher.launch(POST_NOTIFICATIONS)

                    val job = CoroutineScope(Dispatchers.Main.immediate).launch {
                        snapshotFlow { permissionResultState.value }
                            .filterNotNull()
                            .first()
                            .let { result ->
                                permissionContinuation.resume(result)
                            }
                    }

                    permissionContinuation.invokeOnCancellation { job.cancel() }
                }
            }

            override suspend fun goToAppSettings() {
                val activity = context as? Activity ?: return

                val intent = Intent(
                    ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.fromParts(PACKAGE, context.packageName, null)
                )

                activity.startActivity(intent)
            }
        }
    }
}
