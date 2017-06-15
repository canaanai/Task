package com.canaanai.task.core

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.canaanai.task.core.dagger.DaggerTaskDetailComponent
import com.canaanai.task.core.data.TaskDao
import com.canaanai.task.core.databinding.ActivityTaskDetailBinding
import com.canaanai.task.core.viewmodels.TaskViewModel
import javax.inject.Inject

class TaskDetailActivity : AppCompatActivity(), LifecycleRegistryOwner {
    val lifecycleRegistry  = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    //必须加入 lateinit 修饰，否则会报注入错误
    //@Inject lateinit var taskDao: TaskDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityTaskDetailBinding>(this, R.layout.activity_task_detail)
        val viewModel = ViewModelProviders.of(this)[TaskViewModel::class.java]
    }
}
