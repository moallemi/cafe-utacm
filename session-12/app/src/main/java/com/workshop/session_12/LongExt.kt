package com.workshop.session_12


import java.text.SimpleDateFormat
import java.util.*

fun Long?.toTimeString(): String? {
    return this?.let {
        val date = Date(this)
        val formatter = SimpleDateFormat("H:m:s", Locale.ENGLISH)
        formatter.format(date)
    }
}