package com.eventai.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title : String,
    val icon: ImageVector
) {
    object EventsListScreen : Destinations("listEvents", "Events", Icons.Rounded.List)
    object FavoritesEventsScreen: Destinations("favoritesEvents", "Favorites", Icons.Rounded.Star)
}