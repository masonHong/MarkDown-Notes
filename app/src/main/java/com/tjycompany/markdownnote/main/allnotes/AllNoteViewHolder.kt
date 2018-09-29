package com.tjycompany.markdownnote.main.allnotes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.util.FormatUtils
import kotlinx.android.synthetic.main.viewholder_all_notes.view.*

class AllNoteViewHolder(itemView: View, private val listener: AllNotesAdapter.OnNoteClickListener): RecyclerView.ViewHolder(itemView) {
    private var item: AllNotesItem? = null
    init {
        itemView.setOnClickListener {
            listener.onNoteClick(item)
        }
    }
    companion object {
        fun create(parent: ViewGroup, listener: AllNotesAdapter.OnNoteClickListener): AllNoteViewHolder =
                AllNoteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_all_notes, parent, false), listener)
    }

    fun setItem(item: AllNotesItem) {
        this.item = item
        itemView.textTitle.text = item.title
        itemView.textDate.text = FormatUtils.getDateFormatString(item.date)
    }
}