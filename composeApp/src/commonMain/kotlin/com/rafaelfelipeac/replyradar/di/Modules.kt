package com.rafaelfelipeac.replyradar.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.rafaelfelipeac.replyradar.core.database.DatabaseFactory
import com.rafaelfelipeac.replyradar.core.util.datetime.Clock
import com.rafaelfelipeac.replyradar.core.util.datetime.getClock
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }

    single<Clock> { getClock() }
}
