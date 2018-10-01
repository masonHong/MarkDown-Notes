package com.tjycompany.markdownnote.main.allnotes

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tjycompany.markdownnote.R
import com.tjycompany.markdownnote.base.BaseTabFragment
import com.tjycompany.markdownnote.main.NoteDetailActivity
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
                AllNotesItem(100, 1, "홍태준", System.currentTimeMillis() + 10000),
                AllNotesItem(101, 1, "바보", System.currentTimeMillis() + 5000),
                AllNotesItem(102, 1, "말미잘", System.currentTimeMillis())
        )
    }

    override fun onNoteClick(data: AllNotesItem?) {
        data?.toast()
        val sendIntent = Intent(context, NoteDetailActivity::class.java).apply {
            putExtra("NOTE_ITEM", data)
        }
        startActivity(sendIntent)
    }
}