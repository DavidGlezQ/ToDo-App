package com.davidglez.todoapp.addtasks.ui

import com.davidglez.todoapp.addtasks.ui.model.TaskModel

/**
 * Created by davidgonzalez on 22/06/23
 */
sealed interface TasksUiState {
    object Loading: TasksUiState
    data class Error(val throwable: Throwable): TasksUiState
    data class Success(val tasks: List<TaskModel>): TasksUiState

}