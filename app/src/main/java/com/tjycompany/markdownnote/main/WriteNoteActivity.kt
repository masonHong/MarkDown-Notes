package com.tjycompany.markdownnote.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.Menu
import android.view.MenuItem
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.util.toast
import kotlinx.android.synthetic.main.activity_note_write.*

class WriteNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_write)

        val category = SpannableString("카테고리 지정 안됨")
        category.setSpan(UnderlineSpan(), 0, category.length, 0)

        textViewCategory.text = category
        textViewCategory.setOnClickListener {
            "카테고리 선택 버튼 클릭".toast()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_write, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        when (id) {
            R.id.menu_save -> {
                if (editTextTitle.text.toString().isEmpty() && editTextContent.text.toString().isEmpty()) {
                    setResult(Activity.RESULT_CANCELED)
                } else {
                    // DB 에 저장하기. 아래는 임시 데이터
                    val intent = Intent().apply {
                        putExtra("temp_title", editTextTitle.text.toString())
                        putExtra("temp_content", editTextContent.text.toString())
                    }
                    setResult(Activity.RESULT_OK, intent)
                }
                finish()
            }

            R.id.menu_source -> {
                "이미지 첨부하기".toast()
            }

            R.id.menu_popup -> {
                "팝업메뉴".toast()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}
