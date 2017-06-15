package com.canaanai.task.core.bean

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import android.databinding.BaseObservable
import android.databinding.Bindable
import java.io.Serializable

/**
 * @author chenp
 * @version 2017-05-05 15:12
 */
@Entity(foreignKeys = arrayOf(ForeignKey(
        entity = Task::class,
        parentColumns = arrayOf("taskId"),
        childColumns = arrayOf("taskId"),
        onDelete = CASCADE)), indices = arrayOf(Index("taskId", "taskItemId")))
data class TaskItem(var duration: Long,
                    var desc: String?,
                    @Embedded var mediaInfo: MediaInfo?) : Serializable{

    @PrimaryKey(autoGenerate = true) var taskItemId: Int = 0
    var taskId: Int = 0

    fun switch(item: TaskItem){
        val (_dur, _desc, _media) = item

        item.duration = duration
        item.desc = desc
        item.mediaInfo = mediaInfo

        duration = _dur
        desc = _desc
        mediaInfo = _media
    }
}