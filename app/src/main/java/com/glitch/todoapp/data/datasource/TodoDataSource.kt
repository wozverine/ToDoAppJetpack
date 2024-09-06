package com.glitch.todoapp.data.datasource

import com.glitch.todoapp.data.entity.Todos
import com.glitch.todoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(var todoDao: TodoDao) {
	suspend fun save(todo_name: String) {
		val newTodo = Todos(0, todo_name)
		todoDao.save(newTodo)
	}

	suspend fun update(todo_id: Int, todo_name: String) {
		val updatedTodo = Todos(todo_id, todo_name)
		todoDao.update(updatedTodo)
	}

	suspend fun delete(todo_id: Int) {
		val deletedTodo = Todos(todo_id, "")
		todoDao.delete(deletedTodo)
	}

	suspend fun todoUpload(): List<Todos> = withContext(Dispatchers.IO) {
		return@withContext todoDao.todoUpload()
	}

	suspend fun search(queryWord: String): List<Todos> = withContext(Dispatchers.IO) {
		return@withContext todoDao.search(queryWord)
	}
}