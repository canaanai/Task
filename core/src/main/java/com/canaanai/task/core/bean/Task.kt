package com.canaanai.task.core.bean

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * @author chenp
 * @version 2017-06-08 16:20
 */
@Entity(indices = arrayOf(Index("taskId")))
data class Task(var name: String, var createTime: Date){
    @PrimaryKey(autoGenerate = true) var taskId: Int = 0
}