package com.example.mvvm_template.util

import android.app.Application
import com.example.mvvm_template.view.di.myDiModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(applicationContext, myDiModule)
    }
}