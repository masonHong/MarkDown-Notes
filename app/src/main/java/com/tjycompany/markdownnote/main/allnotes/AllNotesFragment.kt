package com.tjycompany.markdownnote.main.allnotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.base.BaseTabFragment
import com.tjycompany.markdownnote.main.MainActivity
import com.tjycompany.markdownnote.main.WriteNoteActivity
import com.tjycompany.markdownnote.model.AllNotesItem
import com.tjycompany.markdownnote.util.toast
import kotlinx.android.synthetic.main.fragment_all_notes.*

class AllNotesFragment : BaseTabFragment(), AllNotesAdapter.OnNoteClickListener {
    private val adapter = AllNotesAdapter(this)

    override fun getTabTitle(): String = "전체 노트"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        adapter.addItems(
                AllNotesItem("홍태준", System.currentTimeMillis() - 10060000),
                AllNotesItem("바보", System.currentTimeMillis() - 5007000),
                AllNotesItem("말미잘", System.currentTimeMillis() - 1500500)
        )

        buttonAdd?.setOnClickListener {
            startActivityForResult(Intent(context, WriteNoteActivity::class.java), MainActivity.REQUEST_CODE_WRITE_MAIN)
        }
    }

    override fun onNoteClick(data: AllNotesItem?) {
        data?.toast()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // 모든 노트보기 페이지에서 추가 버튼을 눌렀을 경우
        if (requestCode == MainActivity.REQUEST_CODE_WRITE_MAIN && resultCode == Activity.RESULT_OK) {
            "저장되었습니다.".toast()
            adapter.addItems(
                    AllNotesItem(data?.getStringExtra("temp_title")
                            ?: "", System.currentTimeMillis()))
        } else {
            "취소되었습니다.".toast()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}