package com.canaanai.task.core.utils

/**
 * @author chenp
 * @version 2017-05-05 16:17
 */
class TimeConvert {
    companion object{
        @JvmStatic
        fun durationSecondToHMS(dSecond: Long): Array<String>{
            val second = dSecond % 60
            var temp = (dSecond - second) / 60
            val minute = temp % 60
            val hour = (temp - minute) / 60

            return arrayOf(hour.toString(), minute.toString(), second.toString())
        }

        @JvmStatic
        fun durationHMSToSecond(hour: String?, minute: String?, second: String?): Long{
            val _hour = hour?.toLong() ?: 0
            val _minute = minute?.toLong() ?: 0
            val _second =second?.toLong() ?: 0

            return _hour * 3600 + _minute * 60 + _second
        }
    }
}