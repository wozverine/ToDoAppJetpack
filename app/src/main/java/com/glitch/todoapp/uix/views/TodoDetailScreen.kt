package com.glitch.todoapp.uix.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.glitch.todoapp.data.entity.Todos
import com.glitch.todoapp.uix.viewmodel.TodoDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoDetailScreen(
	comingTodo: Todos,
	todoDetailViewModel: TodoDetailViewModel,
	navController: NavController
) {
	val tfTodo = remember { mutableStateOf("") }

	LaunchedEffect(key1 = true) {
		tfTodo.value = comingTodo.todo_name
	}

	Scaffold(topBar = { TopAppBar(title = { Text(text = "To Do Detail") }) }) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			TextField(
				value = tfTodo.value,
				onValueChange = { tfTodo.value = it },
				label = { Text(text = "To Do") }
			)

			Button(
				modifier = Modifier.size(250.dp, 50.dp),
				onClick = {
					todoDetailViewModel.update(comingTodo.todo_id, tfTodo.value)
					navController.popBackStack()
				}) { Text(text = "UPDATE") }
		}
	}
}