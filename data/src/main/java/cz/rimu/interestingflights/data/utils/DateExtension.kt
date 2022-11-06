package cz.rimu.interestingflights.data.utils

import java.text.SimpleDateFormat
import java.util.*

fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(format, locale).format(this)

fun getCurrentDateTime(): Date = Calendar.getInstance().time

fun Long.getStringDate(format: String, locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(format, locale).format(Date(this))


fun Date.addDaysToDate(days: Int): Date {
    val cal = Calendar.getInstance()
    cal.time = this
    cal.add(Calendar.DAY_OF_YEAR, days)
    return cal.time
}


