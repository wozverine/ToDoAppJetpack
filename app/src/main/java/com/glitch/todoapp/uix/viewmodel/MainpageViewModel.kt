package com.glitch.todoapp.uix.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.glitch.todoapp.data.entity.Todos
import com.glitch.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainpageViewModel @Inject constructor(var todoRepository: TodoRepository) : ViewModel() {
	var todoList = MutableLiveData<List<Todos>>()

	init {
		todoUpload()
	}

	fun delete(todo_id: Int) {
		CoroutineScope(Dispatchers.Main).launch {
			todoRepository.delete(todo_id)
			todoUpload()
		}
	}

	fun todoUpload() {
		CoroutineScope(Dispatchers.Main).launch {
			todoList.value = todoRepository.todoUpload()
		}
	}

	fun search(queryWord: String) {
		CoroutineScope(Dispatchers.Main).launch {
			todoList.value = todoRepository.search(queryWord)
		}
	}
}