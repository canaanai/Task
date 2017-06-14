package com.canaanai.task.core.dagger

import com.canaanai.task.core.TaskDetailActivity
import dagger.Component
import javax.inject.Singleton

/**
 * @author chenp
 * @version 2017-06-12 16:57
 */
@Component(dependencies = arrayOf(AppComponent::class))
interface TaskDetailComponent {
    fun inject(activity: TaskDetailActivity)

}