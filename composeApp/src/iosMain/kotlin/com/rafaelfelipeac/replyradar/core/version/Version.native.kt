package com.rafaelfelipeac.replyradar.core.version

import platform.Foundation.NSBundle

actual fun getAppVersion(): String {
    val version = NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as? String
    return version ?: "Version unknown."
}
