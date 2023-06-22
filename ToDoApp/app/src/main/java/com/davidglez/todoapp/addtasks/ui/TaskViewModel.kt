package com.davidglez.todoapp.addtasks.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by davidgonzalez on 21/06/23
 */
@HiltViewModel
class TaskViewModel @Inject constructor(): ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    fun onDialogClose() {
        _showDialog.value = false  
    }

    fun onTaskCreated(task: String) {
        Log.i("addTask", task)
        _showDialog.value = false
    }

    fun onShowClicked() {
        _showDialog.value = true
    }
}