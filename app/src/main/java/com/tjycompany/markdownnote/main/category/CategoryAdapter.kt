package com.tjycompany.markdownnote.main.category

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.tjycompany.markdownnote.model.CategoryItem

class CategoryAdapter(private val listener: OnCategoryClickListener) : RecyclerView.Adapter<CategoryViewHolder>() {
    private val items = ArrayList<CategoryItem>()

    interface OnCategoryClickListener {
        fun onCategoryClick(item: CategoryItem?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CategoryViewHolder.create(parent, listener)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setItem(items[position])
    }

    fun addItems(vararg items: CategoryItem) {
        this.items.addAll(items)
        notifyItemRangeInserted(this.items.size - items.size - 1, items.size)
    }

    fun setItems(items: List<CategoryItem>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}