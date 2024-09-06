package com.glitch.todoapp.uix.viewmodel

import androidx.lifecycle.ViewModel
import com.glitch.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetailViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel() {

	fun update(todo_id: Int, todo_name: String) {
		CoroutineScope(Dispatchers.Main).launch {
			todoRepository.update(todo_id, todo_name)
		}
	}
}