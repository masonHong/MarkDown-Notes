package com.tjycompany.markdownnote.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.model.CategoryItem
import com.tjycompany.markdownnote.room.dao.CategoriesDao
import com.tjycompany.markdownnote.room.dao.NotesDao

@Database(
        entities = [AllNotesItem::class, CategoryItem::class],
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
    abstract fun categoriesDao(): CategoriesDao
}