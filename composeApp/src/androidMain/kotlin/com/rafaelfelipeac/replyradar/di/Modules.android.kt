package com.rafaelfelipeac.replyradar.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.rafaelfelipeac.replyradar.core.database.DatabaseFactory
import com.rafaelfelipeac.replyradar.core.preferences.CreateDataStore
import com.rafaelfelipeac.replyradar.core.reminder.ReminderScheduler
import com.rafaelfelipeac.replyradar.core.reminder.ReminderSchedulerImpl
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<HttpClientEngine> { OkHttp.create() }
        single { DatabaseFactory(androidApplication()) }
        single<DataStore<Preferences>> { CreateDataStore(androidApplication()) }
        single<ReminderScheduler> { ReminderSchedulerImpl(androidApplication() as Context) }
    }
