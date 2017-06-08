package com.canaanai.task.core.bean

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * @author chenp
 * @version 2017-05-05 15:12
 */
@Entity(foreignKeys = arrayOf(ForeignKey(
        entity = Task::class,
        parentColumns = arrayOf("taskId"),
        childColumns = arrayOf("taskId"),
        onDelete = CASCADE)))
data class TaskItem(@PrimaryKey(autoGenerate = true) var taskItemId: Int,
                    var taskId: Int,
                    var duration: Long,
                    var desc: String?,
                    @Embedded var mediaInfo: MediaInfo?) : Serializable