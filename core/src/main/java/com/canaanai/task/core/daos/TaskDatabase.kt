package com.canaanai.task.core.daos

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.canaanai.task.core.bean.MediaInfo
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem

/**
 * @author chenp
 * @version 2017-06-08 17:21
 */
@Database(entities = arrayOf(Task::class, MediaInfo::class, TaskItem::class), version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}