package com.canaanai.task.core.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem
import com.canaanai.task.core.daos.TaskDao
import javax.inject.Inject

/**
 * @author chenp
 * @version 2017-06-09 16:09
 */
open class TaskViewModel(val taskId: Int) : ViewModel() {
    @Inject var taskDao: TaskDao? = null

    val title = ObservableField<String>()

    var task: LiveData<Task>? = null
    var taskItem: LiveData<List<TaskItem>>? = null

}