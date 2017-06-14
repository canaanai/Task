package com.canaanai.task.core.dagger

import android.content.Context
import com.canaanai.task.core.App
import com.canaanai.task.core.data.TaskDao
import com.canaanai.task.core.data.TaskDatabase
import dagger.Component
import javax.inject.Singleton

/**
 * @author chenp
 * @version 2017-06-12 17:02
 */
@Singleton
@Component(modules = arrayOf(TaskModule::class))
interface AppComponent {

    fun context(): Context
    fun taskDatabase(): TaskDatabase
    fun taskDao(): TaskDao
}