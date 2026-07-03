package com.example.notesapp.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

fun getCurrentDate(): String{
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("EEE,d MMM y",Locale.getDefault())
    return current.format(formatter)
}