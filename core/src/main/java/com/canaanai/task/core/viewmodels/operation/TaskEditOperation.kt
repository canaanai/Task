package com.canaanai.task.core.viewmodels.operation

import android.databinding.ViewDataBinding
import com.canaanai.task.core.bean.TaskItem
import com.canaanai.task.core.viewmodels.TaskItemViewModel
import com.canaanai.task.core.viewmodels.TaskViewModel

/**
 * @author chenp
 * @version 2017-06-16 11:49
 */
class TaskEditOperation : TaskViewModel.ITaskDetailOperation{
    override fun onLeftButtonClicked() {

    }

    override fun onRightButtonClicked() {

    }

    override fun onItemsBinding(viewDataBinding: ViewDataBinding?, position: Int, data: TaskItem) {
        val itemViewModel = TaskItemViewModel(data)

    }
}