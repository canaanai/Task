package com.canaanai.task.core.bean

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author chenp
 * @version 2017-05-05 11:54
 */
@Entity
data class MediaInfo(var path: String, var type: MediaType){

    @PrimaryKey(autoGenerate = true) var mediaId: Int = 0

    enum class MediaType{
        IMAGE, VIDEO
    }
}