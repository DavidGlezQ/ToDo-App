package com.davidglez.todoapp.addtasks.ui.model

/**
 * Created by davidgonzalez on 21/06/23
 */
data class TaskModel(
    val id: Int = System.currentTimeMillis().hashCode(),
    val task: String,
    var selected: Boolean = false
)
