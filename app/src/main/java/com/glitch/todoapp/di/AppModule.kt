package com.glitch.todoapp.di

import android.content.Context
import androidx.room.Room
import com.glitch.todoapp.room.Veritabani
import com.glitch.todoapp.data.datasource.TodoDataSource
import com.glitch.todoapp.data.repo.TodoRepository
import com.glitch.todoapp.room.TodoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
	@Provides
	@Singleton
	fun provideTodoRepository(todoDao: TodoDataSource): TodoRepository {
		return TodoRepository(todoDao)
	}

	@Provides
	@Singleton
	fun provideTodoDataSource(todoDao: TodoDao): TodoDataSource {
		return TodoDataSource(todoDao)
	}

	@Provides
	@Singleton
	fun provideTodoDao(@ApplicationContext context: Context): TodoDao {
		val vt = Room.databaseBuilder(context, Veritabani::class.java, "todo.sqlite")
			.createFromAsset("todo.sqlite").build()
		return vt.getTodoDao()
	}
}