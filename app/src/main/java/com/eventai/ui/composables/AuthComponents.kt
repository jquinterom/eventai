package com.eventai.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.eventai.navigation.Destinations

@Composable
fun AuthComponents(
    navController: NavController,
    screen: Destinations
) {
    val isLogIn: Boolean = screen == Destinations.LogInScreen

    val buttonModifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)

    val buttonShape = RoundedCornerShape(20.dp)
    val buttonTextStyle = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 16.sp)

    var title = "Log In"
    var btnTextSubmit = "Iniciar Sesión"
    var btnGoAnotherScreen = "Registrar"
    var txtForRegisterText = "¿No estas registrado?"

    if (!isLogIn) {
        title = "Sign Up"
        btnTextSubmit = "Registrar"
        btnGoAnotherScreen = "Iniciar Sesión"
        txtForRegisterText = "¿Ya estas registrado?"
    }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp, bottom = 32.dp, start = 48.dp, end = 48.dp)
    ) {
        val (fields, infoSingUp) = createRefs()

        Column(
            modifier = Modifier
                .constrainAs(fields) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.padding(bottom = 16.dp),
                text = title,
                style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 32.sp)
            )

            // Fields
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 56.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "", onValueChange = {}, placeholder = { Text(text = "Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colors.primary,
                        unfocusedBorderColor = MaterialTheme.colors.secondary
                    )
                )
                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "", onValueChange = {}, placeholder = { Text(text = "Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = MaterialTheme.colors.primary,
                        unfocusedBorderColor = MaterialTheme.colors.secondary
                    )
                )

                if (!isLogIn) {
                    TextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = { Text(text = "Confirm Password") },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = MaterialTheme.colors.primary,
                            unfocusedBorderColor = MaterialTheme.colors.secondary
                        )
                    )
                }

                Button(
                    modifier = buttonModifier,
                    onClick = {
                        if (isLogIn) {
                            navController.navigate(Destinations.EventsListScreen.route)
                        } else {
                            navController.navigate(Destinations.EventsListScreen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                    shape = buttonShape,
                )
                {
                    Text(
                        style = buttonTextStyle,
                        text = btnTextSubmit
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .constrainAs(infoSingUp) {
                    start.linkTo(fields.start)
                    end.linkTo(fields.end)
                    bottom.linkTo(parent.bottom)
                }
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = txtForRegisterText)
            OutlinedButton(
                modifier = buttonModifier,
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                onClick = {
                    if (isLogIn) {
                        navController.navigate(Destinations.SingUpScreen.route)
                    } else {
                        navController.navigate(navController.previousBackStackEntry?.destination?.route.toString()) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                        }
                    }
                },
                border = BorderStroke(1.dp, MaterialTheme.colors.secondary),
                shape = buttonShape,
            ) {
                Text(
                    style = buttonTextStyle,
                    text = btnGoAnotherScreen
                )
            }
        }
    }
}