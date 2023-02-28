package com.eventai.navigation


import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.eventai.navigation.Destinations.*
import com.eventai.ui.screens.*
import com.eventai.ui.screens.auth.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun NavigationHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = LogInScreen.route) {

        composable(
            LogInScreen.route,
        ) {
            LogInScreen(navController = navController)
        }

        composable(
            SingUpScreen.route,
        ) {
            SignUpScreen(navController = navController)
        }

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