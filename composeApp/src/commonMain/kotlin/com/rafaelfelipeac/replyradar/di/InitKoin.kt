package com.rafaelfelipeac.replyradar.di

import com.rafaelfelipeac.replyradar.features.activitylog.di.activityLogModule
import com.rafaelfelipeac.replyradar.features.app.di.appModule
import com.rafaelfelipeac.replyradar.features.reply.di.replyModule
import com.rafaelfelipeac.replyradar.features.settings.di.settingsModule
import com.rafaelfelipeac.replyradar.features.useractions.di.userActionModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            sharedModule,
            platformModule,
            appModule,
            userActionModule,
            replyModule,
            settingsModule,
            activityLogModule
        )
    }
}
