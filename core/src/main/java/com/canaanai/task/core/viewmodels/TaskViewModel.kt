package com.canaanai.task.core.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import android.util.Log
import com.canaanai.task.core.App
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem
import com.canaanai.task.core.dagger.DaggerTaskDetailComponent
import com.canaanai.task.core.data.TaskDao
import com.canaanai.task.core.viewAdapters.RecyclerViewAdapter.BindingHolder
import com.kelin.mvvmlight.command.ReplyCommand
import rx.Observable
import rx.Scheduler
import rx.functions.Action0
import rx.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

/**
 * @author chenp
 * @version 2017-06-09 16:09
 */
class TaskViewModel(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var taskDao: TaskDao

    val title = ObservableField<String>("测试")
    val cmdLeftToolButton = ReplyCommand<Any>(Action0 {  })
    val cmdRightToolButton = ReplyCommand<Any>(Action0 {  })
    val bindingHolder = object : BindingHolder{
        override fun onBinding(viewDataBinding: ViewDataBinding?, position: Int, data: Any) {

        }
    }
    val taskItems = ObservableArrayList<TaskItem>()

    var task: LiveData<Task>? = null
    var taskItem: LiveData<List<TaskItem>>? = null

    init {
        DaggerTaskDetailComponent.builder().appComponent((application as App).appComponent).build().inject(this)

    }

}