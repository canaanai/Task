package com.canaanai.task.core.daos

import android.arch.persistence.room.*
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem

/**
 * @author chenp
 * @version 2017-06-08 16:55
 */
@Dao interface TaskDao {
    @Insert fun addTask(task: Task, taskItems: List<TaskItem>)

    @Update fun updateTaskItem(taskItem: TaskItem)

    @Update fun updateTask(task: Task)

    @Update fun updateTask(task: Task, taskItems: List<TaskItem>)

    @Delete fun deleteTask(task: Task): Int

    @Delete fun deleteTaskItem(taskItem: TaskItem): Int

    @Query("SELECT * FROM Task")
    fun loadAllTasks(): ArrayList<Task>

    @Query("SELECT * FROM Task WHERE taskId == :id")
    fun loadTask(id: Int): ArrayList<Task>

    @Query("SELECT * FROM TaskItem WHERE taskId == :taskId")
    fun loadTaskItems(taskId: Int): ArrayList<TaskItem>
}