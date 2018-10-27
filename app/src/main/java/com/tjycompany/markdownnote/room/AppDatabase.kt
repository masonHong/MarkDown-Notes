package com.tjycompany.markdownnote.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.room.dao.NotesDao

/**
 * Created by mason-hong on 2018. 10. 27..
 */
@Database(
        entities = [AllNotesItem::class],
        version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}