package com.tjycompany.markdownnote.di

import android.arch.persistence.room.Room
import com.tjycompany.markdownnote.main.NotesViewModel
import com.tjycompany.markdownnote.room.AppDatabase
import org.koin.dsl.module.module

val databaseModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "MarkDownNotes").build() }
}

val viewModelModule = module {
    single { NotesViewModel(get()) }
}