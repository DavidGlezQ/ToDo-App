package com.davidglez.todoapp.addtasks.data

import androidx.room.PrimaryKey

/**
 * Created by davidgonzalez on 22/06/23
 */
data class TaskEntity(
    @PrimaryKey val id: Int,
    val task: String,
    var selected: Boolean = false
)