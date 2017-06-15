package com.canaanai.task.core.converters

import android.arch.persistence.room.TypeConverter
import com.canaanai.task.core.bean.MediaInfo
import java.util.*


/**
 * @author chenp
 * @version 2017-06-08 16:02
 */
class RoomTypeConverters{
    companion object{

        @TypeConverter
        @JvmStatic fun mediaTypeToName(type: MediaInfo.MediaType): String{

            return type.name
        }

        @TypeConverter
        @JvmStatic fun nameToMediaType(value: String): MediaInfo.MediaType{
            return MediaInfo.MediaType.valueOf(value)
        }

        @TypeConverter
        @JvmStatic fun fromTimestamp(value: Long?): Date? {
            return if (value == null) null else Date(value)
        }

        @TypeConverter
        @JvmStatic fun dateToTimestamp(date: Date?): Long {
            return date?.time ?: 0
        }
    }
}
