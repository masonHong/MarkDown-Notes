package com.tjycompany.markdownnote.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.tjycompany.markdownnote.model.CategoryItem
import io.reactivex.Flowable

@Dao
interface CategoriesDao {
    @Query("SELECT * FROM CategoryItem")
    fun all(): Flowable<List<CategoryItem>>

    @Insert
    fun insert(vararg items: CategoryItem)
}