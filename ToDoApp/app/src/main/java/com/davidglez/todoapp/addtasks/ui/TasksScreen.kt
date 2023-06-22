package com.davidglez.todoapp.addtasks.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

/**
 * Created by davidgonzalez on 21/06/23
 */

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TasksScreen(tasksViewModel: TaskViewModel) {

    val showDialog: Boolean by tasksViewModel.showDialog.observeAsState(false)

    Box(Modifier.fillMaxSize()) {
        AddTaskDialog(
            show = showDialog,
            onDismiss = { tasksViewModel.onDialogClose() },
            onTaskAdded = { tasksViewModel.onTaskCreated(it) })
        FabDialog(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp), tasksViewModel
        )
    }

}

@Composable
fun FabDialog(modifier: Modifier, tasksViewModel: TaskViewModel) {
    FloatingActionButton(
        onClick = { tasksViewModel.onShowClicked() },
        modifier = modifier
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add note")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskDialog(show: Boolean, onDismiss: () -> Unit, onTaskAdded: (String) -> Unit) {

    var myTask by remember { mutableStateOf("") }

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text(
                    text = "Add your Task",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.size(16.dp))
                TextField(value = myTask, onValueChange = { myTask = it }, singleLine = true)
                Spacer(modifier = Modifier.size(16.dp))
                Button(onClick = { onTaskAdded(myTask) }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Add Task")
                }
            }
        }
    }


}
