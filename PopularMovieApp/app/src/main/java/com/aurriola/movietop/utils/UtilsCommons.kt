package com.aurriola.movietop.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UtilsCommons{

    @RequiresApi(Build.VERSION_CODES.O)
    fun convertDate(date: String): String {
        var formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        var date = LocalDate.parse(date, formatter)
        Log.d("UtilsCommons",date.toString())
        return date.toString()
    }
}