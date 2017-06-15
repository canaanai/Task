package com.canaanai.task.core.dagger

import com.canaanai.task.core.TaskDetailActivity
import com.canaanai.task.core.viewmodels.TaskViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * @author chenp
 * @version 2017-06-12 16:57
 */
@ViewModelScope
@Component(dependencies = arrayOf(AppComponent::class))
interface TaskDetailComponent {
    fun inject(taskViewModel: TaskViewModel)
}