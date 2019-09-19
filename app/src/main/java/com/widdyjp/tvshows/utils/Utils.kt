package com.widdyjp.tvshows.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun dateFormatter(inputDate: String?): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
    val beforeFormat: Date
    var afterFormat = ""

    try {
        beforeFormat = inputFormat.parse(inputDate)
        afterFormat = outputFormat.format(beforeFormat)
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return afterFormat
}