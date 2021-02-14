package com.mkgrimaldos.punkapidemo

import android.app.Application
import com.mkgrimaldos.punkapidemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Start Koin
        startKoin {
            androidLogger()
            androidContext(this@DemoApplication)
            modules(appModule)
        }
    }
}