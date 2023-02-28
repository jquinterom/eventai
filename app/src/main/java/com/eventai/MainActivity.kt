package com.eventai

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
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
    val scaffoldState = rememberScaffoldState()

    val bottomNavigationItems = listOf(
        Destinations.EventsListScreen,
        Destinations.FavoritesEventsScreen
    )

    val appName = stringResource(id = R.string.app_name)
    var title by remember { mutableStateOf(appName) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // State of bottomBar and topBar, set state to false, if current page route is "login or signup"
    val bottomAndTopBarState = rememberSaveable { (mutableStateOf(true)) }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            var currentRoute = backStackEntry.destination.route.toString().split(DELIMITER_SPLIT)[0]

            when (currentRoute) {
                Destinations.LogInScreen.route -> {
                    currentRoute = Destinations.LogInScreen.title
                    bottomAndTopBarState.value = false
                }
                Destinations.SingUpScreen.route -> {
                    currentRoute = Destinations.SingUpScreen.title
                    bottomAndTopBarState.value = false
                }
                Destinations.EventsListScreen.route -> {
                    currentRoute = Destinations.EventsListScreen.title
                    bottomAndTopBarState.value = true
                }
                Destinations.FavoritesEventsScreen.route -> {
                    currentRoute = Destinations.FavoritesEventsScreen.title
                    bottomAndTopBarState.value = true
                }
                Destinations.CreateEventScreen.route -> {
                    currentRoute = Destinations.CreateEventScreen.title
                    bottomAndTopBarState.value = true
                }
                else -> {
                    currentRoute = appName
                    bottomAndTopBarState.value = true
                }
            }
            title = currentRoute

            when (navBackStackEntry?.destination?.route) {
                Destinations.LogInScreen.route -> {
                    // Hide BottomBar and TopBar
                    bottomAndTopBarState.value = false
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = bottomNavigationItems,
                bottomAndTopBarState = bottomAndTopBarState
            )
        },
        topBar = {
            TopNavigationBar(
                title = title,
                navController = navController,
                bottomAndTopBarState = bottomAndTopBarState
            )
        },
        // drawerContent = { Drawer(scope = scope, scaffoldState = scaffoldState, navController, items = drawerNavigationItems) }
    ) {
        NavigationHost(navController)
    }
}
