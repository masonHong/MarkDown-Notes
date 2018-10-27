package com.tjycompany.markdownnote.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class AllNotesItem(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                        var catId: Long = 0,
                        var title: String = "",
                        var date: Long = 0) : Parcelable {
    constructor() : this(catId = 0, title = "", date = 0)
}