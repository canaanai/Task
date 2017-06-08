package com.canaanai.task.core.bean

import android.arch.persistence.room.Entity

/**
 * @author chenp
 * @version 2017-05-05 11:54
 */
@Entity
data class MediaInfo(var path: String, var type: MediaType){

    enum class MediaType{
        IMAGE, VIDEO
    }
}