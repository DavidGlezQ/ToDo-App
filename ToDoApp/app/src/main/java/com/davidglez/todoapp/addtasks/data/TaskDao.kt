package com.davidglez.todoapp.addtasks.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


/**
 * Created by davidgonzalez on 22/06/23
 */
@Dao
interface TaskDao {
    @Query("SELECT * from TaskEntity")
    fun getTasks(): Flow<List<TaskEntity>>

    @Insert
    suspend fun addTask(item: TaskEntity)

    @Update
    suspend fun updateTask(item: TaskEntity)
}