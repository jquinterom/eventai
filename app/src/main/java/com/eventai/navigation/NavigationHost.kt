package com.eventai.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eventai.navigation.Destinations.*
import com.eventai.ui.screens.*

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