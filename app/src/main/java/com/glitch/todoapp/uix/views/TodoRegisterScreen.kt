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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.glitch.todoapp.uix.viewmodel.TodoRegisterViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoRegisterScreen(
	todoRegisterViewModel: TodoRegisterViewModel,
	navController: NavController
) {
	val toDoName = remember { mutableStateOf("") }

	Scaffold(topBar = { TopAppBar(title = { Text(text = "Todo Register") }) }) { paddingValues ->
		Column(
			modifier = Modifier
				.fillMaxSize()
				.padding(paddingValues),
			horizontalAlignment = Alignment.CenterHorizontally,
			verticalArrangement = Arrangement.SpaceEvenly
		) {
			TextField(
				value = toDoName.value,
				onValueChange = { toDoName.value = it },
				label = { Text(text = "To Do") }
			)

			Button(
				modifier = Modifier.size(250.dp, 50.dp),
				onClick = {
					todoRegisterViewModel.save(toDoName.value)
					navController.popBackStack()
				}) { Text(text = "SAVE") }
		}
	}
}