package com.canaanai.task.core.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import com.canaanai.task.core.App
import com.canaanai.task.core.bean.Task
import com.canaanai.task.core.bean.TaskItem
import com.canaanai.task.core.dagger.DaggerTaskDetailComponent
import com.canaanai.task.core.data.TaskDao
import com.canaanai.task.core.viewAdapters.RecyclerViewAdapter.BindingHolder
import com.canaanai.task.core.viewmodels.operation.TaskEditOperation
import com.kelin.mvvmlight.command.ReplyCommand
import rx.Observable
import rx.functions.Action0
import rx.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author chenp
 * @version 2017-06-09 16:09
 */
class TaskViewModel(application: Application) : AndroidViewModel(application) {

    @Inject lateinit var taskDao: TaskDao

    var task: Task? = null
        private set
    var operation: ITaskDetailOperation? =null

    val isEditable = ObservableBoolean(true)
    val title = ObservableField<String>("测试")
    val cmdLeftToolButton = ReplyCommand<Any>(Action0 { operation?.onLeftButtonClicked() })
    val cmdRightToolButton = ReplyCommand<Any>(Action0 { operation?.onRightButtonClicked() })
    val taskItems = ObservableArrayList<TaskItem>()
    val bindingHolder = object : BindingHolder{
        override fun onBinding(viewDataBinding: ViewDataBinding?, position: Int, data: Any?) {
            operation?.onItemsBinding(viewDataBinding, position, data as TaskItem)
        }
    }

    init {
        DaggerTaskDetailComponent.builder().appComponent((application as App).appComponent).build().inject(this)

        operation = TaskEditOperation()
    }

    fun loadTask(taskId: Int){
        Observable.just(taskId)
                .observeOn(Schedulers.io())
                .map { taskDao.loadTask(taskId) }
                .takeWhile { it.isNotEmpty() }
                .doOnNext { task = it[0] }
                .doOnNext { title.set(it[0].name) }
                .subscribe()

        loadTaskItems(taskId)
    }

    fun loadTaskItems(taskId: Int){
        Observable.just(taskId)
                .observeOn(Schedulers.io())
                .map { taskDao.loadTaskItems(taskId) }
                .doOnNext { taskItems.addAll(it) }
                .subscribe()
    }

    interface ITaskDetailOperation{
        fun onLeftButtonClicked()
        fun onRightButtonClicked()
        fun onItemsBinding(viewDataBinding: ViewDataBinding?, position: Int, data: TaskItem)
    }
}