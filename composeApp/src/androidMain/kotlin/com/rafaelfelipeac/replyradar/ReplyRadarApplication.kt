package com.rafaelfelipeac.replyradar

import android.app.Application
import com.rafaelfelipeac.replyradar.di.initKoin
import org.koin.android.ext.koin.androidContext

class ReplyRadarApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@ReplyRadarApplication)
        }
    }
}