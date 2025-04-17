package com.rafaelfelipeac.replyradar.core.util

expect fun openEmailApp(
    to: String,
    subject: String,
    body: String
)

expect fun openPlayStoreApp(appPackageName: String)
