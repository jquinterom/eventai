package com.eventai.ui.screens.auth

import android.content.res.Configuration
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.eventai.navigation.Destinations
import com.eventai.ui.composables.AuthComponents
import com.eventai.ui.theme.EventaiTheme

@Composable
fun LogInScreen(
    navController: NavController
) {
    AuthComponents(navController = navController, screen = Destinations.LogInScreen)
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LogInScreenPreview() {
    EventaiTheme {
        Surface {
            LogInScreen(rememberNavController())
        }
    }
}