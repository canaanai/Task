package com.canaanai.task.core.viewmodels

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ObservableList
import android.databinding.ViewDataBinding
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem
import com.canaanai.task.core.data.TaskDao
import com.canaanai.task.core.viewAdapters.RecyclerViewAdapter
import com.canaanai.task.core.viewAdapters.RecyclerViewAdapter.BindingHolder
import com.kelin.mvvmlight.command.ReplyCommand
import rx.functions.Action0
import javax.inject.Inject

/**
 * @author chenp
 * @version 2017-06-09 16:09
 */
abstract class TaskViewModel(val taskId: Int) : ViewModel() {

    val title = ObservableField<String>()
    val cmdLeftToolButton = ReplyCommand<Any>(Action0 { onLeftButtonClicked() })
    val cmdRightToolButton = ReplyCommand<Any>(Action0 { onRightButtonClicked() })
    val bindingHolder = object : BindingHolder{
        override fun onBinding(viewDataBinding: ViewDataBinding?, position: Int, data: Any) {
            onItemBinding(viewDataBinding, position, data)
        }
    }
    val taskItems = ObservableArrayList<TaskItem>()

    var task: LiveData<Task>? = null
    var taskItem: LiveData<List<TaskItem>>? = null

    init {

    }

    abstract fun onLeftButtonClicked()
    abstract fun onRightButtonClicked()
    abstract fun onItemBinding(viewDataBinding: ViewDataBinding?, position: Int, data: Any)
}