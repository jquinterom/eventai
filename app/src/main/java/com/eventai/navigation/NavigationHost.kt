package com.eventai.navigation


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eventai.navigation.Destinations.*
import com.eventai.ui.screens.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = EventsListScreen.route) {
        composable(EventsListScreen.route) {
            EventsListScreen()
        }

        composable(
            FavoritesEventsScreen.route,
        ) {
            FavoritesEventsScreen()
        }

        composable(
            CreateEventScreen.route,
        ) {
            CreateEventScreen()
        }
    }
}