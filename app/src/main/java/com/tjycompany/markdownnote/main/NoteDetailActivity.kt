package com.tjycompany.markdownnote.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.style.UnderlineSpan
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.util.FormatUtils
import kotlinx.android.synthetic.main.activity_note_detail.*

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val item = intent.getParcelableExtra<AllNotesItem>("NOTE_ITEM")

        val category = SpannableString(item.catId.toString() + " 투 두 리스트") // 카테고리 텍스트 변환 필요
        category.setSpan(UnderlineSpan(), 0, category.length, 0)

        textViewCategory.text = category
        textViewTitle.text = item.title
        textViewContents.text = "임시 데이터!!!!!!!!!!!!꺄륵!!!\n 개행 먹히나?"
        textViewDate.text = FormatUtils.getDateFormatString(item.date)
    }
}
