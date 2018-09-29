package com.tjycompany.markdownnote.util

import java.text.SimpleDateFormat
import java.util.*

object FormatUtils {
    private const val dateFormatPattern = "yyyy.MM.dd HH:mm"

    fun getDateFormatString(date: Long): String =
            SimpleDateFormat(dateFormatPattern, Locale.getDefault()).format(date)
}