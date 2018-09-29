package com.tjycompany.markdownnote.util

import android.widget.Toast
import com.tjycompany.markdownnote.AppApplication

fun Any.toast() {
    Toast.makeText(AppApplication.CONTEXT, this.toString(), Toast.LENGTH_SHORT).show()
}