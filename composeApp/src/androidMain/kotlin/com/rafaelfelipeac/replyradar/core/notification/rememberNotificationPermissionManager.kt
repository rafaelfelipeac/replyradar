package com.rafaelfelipeac.replyradar.core.notification

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

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
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                    return true
                }

                val granted = ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED

                if (granted) {
                    return true
                }

                // Launch and suspend for result
                return suspendCancellableCoroutine { cont ->
                    permissionResultState.value = null
                    permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)

                    val scope = CoroutineScope(Dispatchers.Main.immediate)

                    val job = scope.launch {
                        snapshotFlow { permissionResultState.value }
                            .filterNotNull()
                            .first()
                            .let { result ->
                                cont.resume(result)
                            }
                    }

                    cont.invokeOnCancellation { job.cancel() }
                }
            }
        }
    }
}

