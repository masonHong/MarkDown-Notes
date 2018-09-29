package com.tjycompany.markdownnote.main.category

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.base.BaseTabFragment
import com.tjycompany.markdownnote.model.CategoryItem
import com.tjycompany.markdownnote.util.toast
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : BaseTabFragment(), CategoryAdapter.OnCategoryClickListener {
    private val adapter = CategoryAdapter(this)

    override fun getTabTitle(): String = "카테고리"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        adapter.addItems(
                CategoryItem(1, "카카오", 10),
                CategoryItem(2, "취업", 5),
                CategoryItem(3, "데이트", 1),
                CategoryItem(4, "기타", 4)
        )
    }

    override fun onCategoryClick(item: CategoryItem?) {
        item?.toast()
    }
}