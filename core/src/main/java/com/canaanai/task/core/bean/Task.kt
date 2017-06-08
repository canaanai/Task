package com.canaanai.task.core.bean

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * @author chenp
 * @version 2017-06-08 16:20
 */
@Entity
data class Task(@PrimaryKey(autoGenerate = true) var taskId: Int, var name: String, var createTime: Date)