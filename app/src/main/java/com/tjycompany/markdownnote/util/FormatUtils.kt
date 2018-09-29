package com.tjycompany.markdownnote.util

import java.text.SimpleDateFormat
import java.util.*

object FormatUtils {
    fun getDateFormatString(date: Long): String =
            SimpleDateFormat("yyyy.MM.dd hh:mm", Locale.getDefault()).format(date)
}