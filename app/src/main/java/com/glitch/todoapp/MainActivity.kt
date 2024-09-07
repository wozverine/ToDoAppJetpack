package com.glitch.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.glitch.todoapp.ui.theme.ToDoAppTheme
import com.glitch.todoapp.uix.viewmodel.MainpageViewModel
import com.glitch.todoapp.uix.viewmodel.TodoDetailViewModel
import com.glitch.todoapp.uix.viewmodel.TodoRegisterViewModel
import com.glitch.todoapp.uix.views.PageSwitch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	val todoRegisterViewModel: TodoRegisterViewModel by viewModels()
	val todoDetailViewModel: TodoDetailViewModel by viewModels()
	val mainpageViewModel: MainpageViewModel by viewModels()
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			ToDoAppTheme {
				PageSwitch(mainpageViewModel, todoRegisterViewModel, todoDetailViewModel)
			}
		}
	}
}