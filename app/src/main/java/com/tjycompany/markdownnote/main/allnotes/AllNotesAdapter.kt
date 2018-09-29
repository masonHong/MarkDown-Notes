package com.tjycompany.markdownnote.main.allnotes

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.tjycompany.markdownnote.model.AllNotesItem

class AllNotesAdapter(private val listener: OnNoteClickListener) : RecyclerView.Adapter<AllNoteViewHolder>() {

    private val items = ArrayList<AllNotesItem>()

    interface OnNoteClickListener {
        fun onNoteClick(data: AllNotesItem?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AllNoteViewHolder.create(parent, listener)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(viewHolder: AllNoteViewHolder, position: Int) {
        viewHolder.setItem(items[position])
    }

    fun addItems(vararg item: AllNotesItem) {
        items.addAll(item)
        notifyItemRangeInserted(items.size - item.size - 1, item.size)
    }

    fun setItems(items: List<AllNotesItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}