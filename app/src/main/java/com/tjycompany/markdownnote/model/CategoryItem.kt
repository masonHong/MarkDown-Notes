package com.tjycompany.markdownnote.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class CategoryItem(@PrimaryKey(autoGenerate = true) var id: Long,
                        var name: String? = null,
                        var count: Int) : Parcelable {
    constructor() : this(0, "", 0)
}