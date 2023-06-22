package com.davidglez.todoapp.addtasks.ui.model

/**
 * Created by davidgonzalez on 21/06/23
 */
data class TaskModel(
    val id: Long = System.currentTimeMillis(),
    val task: String,
    var selected: Boolean = false
)
