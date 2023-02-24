package com.eventai

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.rememberNavController
import com.eventai.constants.DELIMITER_SPLIT
import com.eventai.navigation.*
import com.eventai.ui.theme.EventaiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EventaiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    val bottomNavigationItems = listOf(
        Destinations.EventsListScreen,
        Destinations.FavoritesEventsScreen
    )

    val appName = stringResource(id = R.string.app_name)
    var title by remember { mutableStateOf(appName) }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            var currentRoute = backStackEntry.destination.route.toString().split(DELIMITER_SPLIT)[0]

            currentRoute = when (currentRoute) {
                Destinations.EventsListScreen.route -> {
                    Destinations.EventsListScreen.title
                }
                Destinations.FavoritesEventsScreen.route -> {
                    Destinations.FavoritesEventsScreen.title
                }
                else -> {
                    appName
                }
            }

            title = currentRoute
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomNavigationBar(navController = navController, items = bottomNavigationItems) },
        topBar = { TopNavigationBar(scope = scope, scaffoldState = scaffoldState, title = title) },
        // drawerContent = { Drawer(scope = scope, scaffoldState = scaffoldState, navController, items = drawerNavigationItems) }
    ) {
        NavigationHost(navController)
    }
}
