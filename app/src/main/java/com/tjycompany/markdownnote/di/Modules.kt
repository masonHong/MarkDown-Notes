package com.tjycompany.markdownnote.di

import android.arch.persistence.room.Room
import com.tjycompany.markdownnote.main.NotesViewModel
import com.tjycompany.markdownnote.room.AppDatabase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val databaseModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "MarkDownNotes").build() }
    single { get<AppDatabase>().notesDao() }
}

val viewModelModule = module {
    viewModel { NotesViewModel(get()) }
}