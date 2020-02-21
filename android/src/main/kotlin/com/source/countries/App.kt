package com.source.countries

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @project Countries
 * @author SourceOne on 21.02.2020
 */

class App: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(allModules)
        }
    }
}