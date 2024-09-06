package com.glitch.todoapp.uix.views

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.glitch.todoapp.data.entity.Todos
import com.glitch.todoapp.uix.viewmodel.MainpageViewModel
import com.glitch.todoapp.uix.viewmodel.TodoDetailViewModel
import com.glitch.todoapp.uix.viewmodel.TodoRegisterViewModel
import com.google.gson.Gson

@Composable
fun PageSwitch(
	mainpageViewModel: MainpageViewModel,
	todoRegisterViewModel: TodoRegisterViewModel,
	todoDetailViewModel: TodoDetailViewModel
) {
	val navController = rememberNavController()

	NavHost(navController = navController, startDestination = "mainpage") {
		composable("mainpage") {
			Mainpage(navController, mainpageViewModel)
		}
		composable("todoRegisterPage") {
			TodoRegisterScreen(todoRegisterViewModel)
		}
		composable(
			route = "todoDeatilPage/{todo}",
			arguments = listOf(
				navArgument("todo") { type = NavType.StringType }
			)
		) {
			val json = it.arguments?.getString("todo")
			val nesne = Gson().fromJson(json, Todos::class.java)
			TodoDetailScreen(nesne, todoDetailViewModel)
		}
	}
}