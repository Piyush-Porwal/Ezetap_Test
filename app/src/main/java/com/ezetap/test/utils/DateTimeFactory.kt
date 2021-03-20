package com.ezetap.test.utils

import java.text.SimpleDateFormat
import java.util.*

object DateTimeFactory {

    fun getCurrentDateWithFormat(format:String): String{
       return SimpleDateFormat(format, Locale.getDefault()).format(Calendar.getInstance().time)
    }

    fun getDateStringWithFormat(date: Date, format: String): String{
        return SimpleDateFormat(format, Locale.getDefault()).format(date)
    }

    fun convertEpochTimeToDateString(format: String, epochTime: Long): String{
        return SimpleDateFormat(format, Locale.getDefault()).format(Date(epochTime))
    }

    fun getDateStringFromCalendarWithFormat(day: Int, month: Int, year: Int, format: String): String {
        val calendar = Calendar.getInstance()
        calendar.set(year,month,day)
        return SimpleDateFormat(format, Locale.getDefault()).format(calendar.time)
    }

    fun getDateFromCalendar(day: Int, month: Int, year: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.set(year,month,day)
        return calendar.time
    }

    fun getDateFromDateString(format: String, date: String):Date?{
        return SimpleDateFormat(format,Locale.getDefault()).parse(date)
    }


}