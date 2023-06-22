package com.davidglez.todoapp.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by davidgonzalez on 22/06/23
 */
@Database(entities = [TaskEntity::class], version = 1)
abstract class TodoAppDataBase: RoomDatabase() {
    abstract fun taskDao():TaskDao
}