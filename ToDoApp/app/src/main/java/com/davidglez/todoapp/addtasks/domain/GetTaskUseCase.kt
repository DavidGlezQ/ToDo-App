package com.davidglez.todoapp.addtasks.domain

import com.davidglez.todoapp.addtasks.data.TaskRepository
import com.davidglez.todoapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by davidgonzalez on 22/06/23
 */
class GetTaskUseCase @Inject constructor(private val taskRepository: TaskRepository) {
    operator fun invoke(): Flow<List<TaskModel>> = taskRepository.tasks
}