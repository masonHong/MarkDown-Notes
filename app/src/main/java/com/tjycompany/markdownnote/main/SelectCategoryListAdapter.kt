package com.tjycompany.markdownnote.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjycompany.markdownnote.AppApplication
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.model.CategoryItem
import kotlinx.android.synthetic.main.viewholder_category.view.*

class SelectCategoryListAdapter : RecyclerView.Adapter<DefaultViewHolder>() {
    companion object {
        private const val VIEW_TYPE_ITEM = 1
        private const val VIEW_TYPE_FOOTER = 2
    }

    private val categories = ArrayList<CategoryItem>()

    fun setItems(items: List<CategoryItem>) {
        categories.clear()
        categories.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> CategoryViewHolder.create(parent)
            else -> AddCategoryViewHolder.create(parent)
        }
    }

    override fun getItemCount(): Int = categories.size + 1

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
        if (position < categories.size) {
            holder.bind(categories[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position < categories.size) {
            VIEW_TYPE_ITEM
        } else {
            VIEW_TYPE_FOOTER
        }
    }
}

abstract class DefaultViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: Any?)
}

class CategoryViewHolder private constructor(itemView: View) : DefaultViewHolder(itemView) {
    private var item: CategoryItem? = null

    companion object {
        fun create(parent: ViewGroup) = CategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_category, parent, false))
    }

    override fun bind(item: Any?) {
        if (item is CategoryItem) {
            this.item = item
            itemView.textCategoryName.text = item.name
            itemView.textCount.text = AppApplication.CONTEXT.getString(R.string.category_item_count, item.count)
        }
    }
}

class AddCategoryViewHolder private constructor(itemView: View) : DefaultViewHolder(itemView) {
    companion object {
        fun create(parent: ViewGroup) = AddCategoryViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_add_category, parent, false))
    }

    override fun bind(item: Any?) {
    }
}