package com.tjycompany.markdownnote.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.tjycompany.markdownnote.model.AllNotesItem
import io.reactivex.Flowable

/**
 * Created by mason-hong on 2018. 10. 27..
 */
@Dao
interface NotesDao {
    @Query("SELECT * FROM AllNotesItem")
    fun getAllNotes(): Flowable<List<AllNotesItem>>
}