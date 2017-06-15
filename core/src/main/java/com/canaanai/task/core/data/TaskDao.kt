package com.canaanai.task.core.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem

/**
 * @author chenp
 * @version 2017-06-08 16:55
 */
@Dao interface TaskDao {
    @Insert fun addTask(task: Task)

    @Update fun updateTaskItem(taskItem: TaskItem)

    @Update fun updateTask(task: Task)

    @Delete fun deleteTask(task: Task): Int

    @Delete fun deleteTaskItem(taskItem: TaskItem): Int

    @Query("SELECT * FROM Task")
    fun loadAllTasks(): LiveData<List<Task>>

    @Query("SELECT * FROM Task WHERE taskId == :p0")
    fun loadTask(id: Int): LiveData<List<Task>>

    @Query("SELECT * FROM TaskItem WHERE taskId == :p0")
    fun loadTaskItems(taskId: Int): LiveData<List<TaskItem>>
}