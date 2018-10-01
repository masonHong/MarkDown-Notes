package com.tjycompany.markdownnote.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AllNotesItem(val id: Long,
                        val catId: Long,
                        var title: String,
                        var date: Long) : Parcelable