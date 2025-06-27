package com.rafaelfelipeac.replyradar.core.external

expect fun openEmailApp(to: String, subject: String, body: String)

expect fun openPlayStoreApp(appPackageName: String)
