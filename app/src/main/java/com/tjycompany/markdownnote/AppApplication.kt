package com.tjycompany.markdownnote

import android.annotation.SuppressLint
import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.tjycompany.markdownnote.di.databaseModule
import com.tjycompany.markdownnote.di.viewModelModule
import com.tjycompany.markdownnote.room.AppDatabase
import org.koin.android.ext.android.startKoin
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
        startKoin(this, arrayListOf(databaseModule, viewModelModule))
    }
}