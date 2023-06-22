package com.davidglez.todoapp.addtasks.domain

import com.davidglez.todoapp.addtasks.data.TaskRepository
import com.davidglez.todoapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

/**
 * Created by davidgonzalez on 22/06/23
 */
class DeleteTaskUseCase @Inject constructor(private val taskRepository: TaskRepository){
    suspend operator fun invoke(taskModel: TaskModel) {
        taskRepository.delete(taskModel)
    }
}