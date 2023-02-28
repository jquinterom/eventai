package com.eventai.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title : String,
    val icon: ImageVector
) {
    object EventsListScreen : Destinations("listEvents", "Events", Icons.Rounded.List)
    object FavoritesEventsScreen: Destinations("favoritesEvents", "Favorites", Icons.Rounded.Star)
    object CreateEventScreen: Destinations("createEvent", "Create Event", Icons.Rounded.Create)
    object LogInScreen: Destinations("logIn", "Log In", Icons.Rounded.AccountBox)
    object SingUpScreen: Destinations("singUp", "Sing Up", Icons.Rounded.AccountCircle)
}