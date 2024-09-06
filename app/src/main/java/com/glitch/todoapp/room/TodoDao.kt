package com.glitch.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.glitch.todoapp.data.entity.Todos

@Dao
interface TodoDao {
	@Query("SELECT * FROM toDos")
	suspend fun todoUpload(): List<Todos>

	@Insert
	suspend fun save(todo: Todos)

	@Update
	suspend fun update(todo: Todos)

	@Delete
	suspend fun delete(todo: Todos)

	@Query("SELECT * FROM toDos WHERE todo_name like '%' || :queryWord || '%'")
	suspend fun search(queryWord: String): List<Todos>
}