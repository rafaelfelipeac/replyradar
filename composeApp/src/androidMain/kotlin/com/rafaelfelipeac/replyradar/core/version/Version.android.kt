package com.rafaelfelipeac.replyradar.core.version

import android.content.Context
import com.rafaelfelipeac.replyradar.R
import com.rafaelfelipeac.replyradar.ReplyRadarApplication

actual fun getAppVersion(): String {
    val context: Context = ReplyRadarApplication.instance.applicationContext
    val packageInfo = context.packageManager.getPackageInfo(context.packageName, 0)

    return packageInfo.versionName ?: context.getString(R.string.version_unknown)
}
