package cz.rimu.interestingflights.data.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.getStringDate(format: String, locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat(format, locale).format(Date(this))



