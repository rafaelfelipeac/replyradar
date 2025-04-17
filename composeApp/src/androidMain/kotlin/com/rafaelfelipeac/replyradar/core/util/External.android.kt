package com.rafaelfelipeac.replyradar.core.util

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.Intent.ACTION_SENDTO
import android.content.Intent.ACTION_VIEW
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.net.Uri.encode
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.core.net.toUri
import com.rafaelfelipeac.replyradar.R.string.no_email_app_found
import com.rafaelfelipeac.replyradar.ReplyRadarApplication

actual fun openEmailApp(to: String, subject: String, body: String) {
    val context = ReplyRadarApplication.instance.applicationContext

    val encodedSubject = encode(subject)
    val encodedBody = encode(body)

    val uriString = "mailto:$to?subject=$encodedSubject&body=$encodedBody"
    val intent = Intent(ACTION_SENDTO).apply {
        data = uriString.toUri()
        addFlags(FLAG_ACTIVITY_NEW_TASK)
    }

    try {
        context.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, context.getString(no_email_app_found), LENGTH_SHORT).show()
    }
}

actual fun openPlayStoreApp(appPackageName: String) {
    val context = ReplyRadarApplication.instance.applicationContext

    val intent = Intent(ACTION_VIEW).apply {
        data = "$PLAY_STORE_URI$appPackageName".toUri()
        addFlags(FLAG_ACTIVITY_NEW_TASK)
    }

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        val webIntent = Intent(ACTION_VIEW).apply {
            data = "$PLAY_STORE_URL$appPackageName".toUri()
            addFlags(FLAG_ACTIVITY_NEW_TASK)
        }

        context.startActivity(webIntent)
    }
}

private const val PLAY_STORE_URI = "market://details?id="
private const val PLAY_STORE_URL = "https://play.google.com/store/apps/details?id="
