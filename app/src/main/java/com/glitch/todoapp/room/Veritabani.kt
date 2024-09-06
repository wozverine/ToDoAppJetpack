package com.glitch.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.glitch.todoapp.data.entity.Todos

@Database(entities = [Todos::class], version = 1)
abstract class Veritabani : RoomDatabase() {
	abstract fun getTodoDao(): TodoDao
}