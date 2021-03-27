package com.example.android.navdrawerformacion.commons

import android.app.Application
import com.example.android.data.di.dataModule
import com.example.android.navdrawerformacion.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)   //Context
            modules(listOf(dataModule, uiModule))   //Modules
        }
    }
}