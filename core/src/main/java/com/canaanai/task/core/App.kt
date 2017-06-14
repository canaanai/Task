package com.canaanai.task.core

import android.app.Application
import com.canaanai.task.core.dagger.AppComponent
import com.canaanai.task.core.dagger.DaggerAppComponent
import com.canaanai.task.core.dagger.TaskModule

/**
 * @author chenp
 * @version 2017-06-12 17:10
 */
class App: Application() {

    var appComponent: AppComponent? = null
    private set

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().taskModule(TaskModule(this)).build()
    }
}