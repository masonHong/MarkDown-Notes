package com.tjycompany.markdownnote.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.model.CategoryItem
import kotlinx.android.synthetic.main.activity_select_category.*

class SelectCategoryActivity : AppCompatActivity() {
    private val adapter = SelectCategoryListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_category)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        adapter.setItems(listOf(CategoryItem(1, "카카오", 10),
                CategoryItem(2, "취업", 5),
                CategoryItem(3, "데이트", 1),
                CategoryItem(4, "기타", 4)))
    }
}
