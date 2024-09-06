package com.glitch.todoapp.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.glitch.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoRegisterViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel() {
	fun save(todo_name: String) {
		CoroutineScope(Dispatchers.Main).launch {
			todoRepository.save(todo_name)
		}
	}
}