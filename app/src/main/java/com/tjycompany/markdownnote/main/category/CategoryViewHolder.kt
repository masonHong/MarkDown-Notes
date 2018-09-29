package com.tjycompany.markdownnote.main.category

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjycompany.markdownnote.AppApplication
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.model.CategoryItem
import kotlinx.android.synthetic.main.viewholder_category.view.*

class CategoryViewHolder(itemView: View,
                         private val listener: CategoryAdapter.OnCategoryClickListener) : RecyclerView.ViewHolder(itemView) {
    private var item: CategoryItem? = null

    init {
        itemView.setOnClickListener {
            listener.onCategoryClick(item)
        }
    }

    companion object {
        fun create(parent: ViewGroup, listener: CategoryAdapter.OnCategoryClickListener) =
                CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_category, parent, false), listener)
    }

    fun setItem(item: CategoryItem?) {
        this.item = item
        itemView.textCategoryName.text = item?.name
        itemView.textCount.text =
                AppApplication.CONTEXT.getString(R.string.category_item_count, item?.count ?: 0)
    }
}