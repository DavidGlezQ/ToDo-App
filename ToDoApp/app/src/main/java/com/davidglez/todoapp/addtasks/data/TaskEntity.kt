package com.davidglez.todoapp.addtasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by davidgonzalez on 22/06/23
 */
@Entity
data class TaskEntity(
    @PrimaryKey val id: Int,
    val task: String,
    var selected: Boolean = false
)