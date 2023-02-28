package com.eventai.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import com.eventai.navigation.Destinations.CreateEventScreen

@Composable
fun TopNavigationBar(
    title: String,
    navController: NavController,
    bottomAndTopBarState: MutableState<Boolean>
) {
    if (!bottomAndTopBarState.value) {
        return
    }

    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            Icon(imageVector = Icons.Rounded.Menu, contentDescription = null)
        },
        actions = {
            IconButton(onClick = {
                navController.navigate(CreateEventScreen.route) {
                }
            }) {
                Icon(
                    imageVector = Icons.Rounded.Create,
                    contentDescription = null
                )
            }
        }
    )
}