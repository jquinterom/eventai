package com.eventai.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eventai.navigation.Destinations.FavoritesEventsScreen
import com.eventai.navigation.Destinations.EventsListScreen
import com.eventai.ui.screens.EventsListScreen
import com.eventai.ui.screens.FavoritesEventsScreen

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
    }
}