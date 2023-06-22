package com.davidglez.todoapp.addtasks.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.davidglez.todoapp.addtasks.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by davidgonzalez on 21/06/23
 */
@HiltViewModel
class TaskViewModel @Inject constructor(): ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    //Cuando queremos llenar un lazyColum es mejor usar un mutableStateListOf ya que va mejor para la recomposicion de compose
    private val _task = mutableStateListOf<TaskModel>()
    val task: List<TaskModel> = _task

    fun onDialogClose() {
        _showDialog.value = false  
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false
        _task.add(TaskModel(task = task))
    }

    fun onShowClicked() {
        _showDialog.value = true
    }

    fun onCheckedBoxSelected(taskModel: TaskModel) {

    }
}