package com.glitch.todoapp.data.repo

import com.glitch.todoapp.data.datasource.TodoDataSource
import com.glitch.todoapp.data.entity.Todos

class TodoRepository(var tds: TodoDataSource) {
	suspend fun save(todo_name: String) = tds.save(todo_name)

	suspend fun update(todo_id: Int, todo_name: String) = tds.update(todo_id, todo_name)

	suspend fun delete(todo_id: Int) = tds.delete(todo_id)

	suspend fun todoUpload(): List<Todos> = tds.todoUpload()

	suspend fun search(queryWord: String): List<Todos> = tds.search(queryWord)
}