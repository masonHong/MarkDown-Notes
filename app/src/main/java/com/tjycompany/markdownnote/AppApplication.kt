package com.tjycompany.markdownnote

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import timber.log.Timber

class AppApplication: Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var CONTEXT: Context
    }
    override fun onCreate() {
        super.onCreate()
        CONTEXT = this

        Timber.plant(Timber.DebugTree())
    }
}