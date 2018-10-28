package com.tjycompany.markdownnote.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class AllNotesItem(@PrimaryKey(autoGenerate = true) var id: Long,
                        var catId: Long,
                        var title: String,
                        var content: String,
                        var date: Long) : Parcelable {
    constructor() : this(0, 0, "", "", 0)
}