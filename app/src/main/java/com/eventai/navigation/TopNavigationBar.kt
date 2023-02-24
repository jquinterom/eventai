package com.eventai.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun TopNavigationBar(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    title: String,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        }
    )
}