package com.canaanai.task.core.dagger

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.canaanai.task.core.data.TaskDao
import com.canaanai.task.core.data.TaskDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author chenp
 * @version 2017-06-12 16:49
 */
@Module
class TaskModule(val application: Application) {

    @Provides @Singleton fun provideContext(): Context{
        return application
    }

    @Provides @Singleton fun provideTaskDatabase(context: Context): TaskDatabase{
        return Room.databaseBuilder(context, TaskDatabase::class.java, "taskDB").build()
    }

    @Provides @Singleton fun provideTaskDao(database: TaskDatabase): TaskDao{
        return database.taskDao()
    }
}