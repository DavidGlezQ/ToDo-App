package com.davidglez.todoapp.addtasks.data.di

import android.content.Context
import androidx.room.Room
import com.davidglez.todoapp.addtasks.data.TaskDao
import com.davidglez.todoapp.addtasks.data.TodoAppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by davidgonzalez on 22/06/23
 */
@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun providesTasksDao(todoAppDataBase: TodoAppDataBase): TaskDao {
        return todoAppDataBase.taskDao()
    }

    @Provides
    @Singleton
    fun provideTodoDataBase(@ApplicationContext applicationContext: Context): TodoAppDataBase {
        return Room.databaseBuilder(applicationContext, TodoAppDataBase::class.java, "TaskDataBase").build()
    }
}