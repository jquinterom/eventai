package com.eventai.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.constraintlayout.compose.ConstraintLayout
import com.eventai.R
import com.eventai.ui.theme.EventaiTheme

@Composable
fun CreateEventScreen() {

    var showCustomDialogWithResult by remember { mutableStateOf(false) }

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (btnAddPicture, boxTextFields) = createRefs()

        IconButton(
            modifier = Modifier
                .constrainAs(btnAddPicture) {
                    end.linkTo(parent.end)
                }
                .clip(RoundedCornerShape(10.dp)),
            onClick = { /*TODO*/ }
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add), contentDescription = null
                )
                Text(
                    text = "Agregar foto"
                )
            }
        }

        ConstraintLayout(
            modifier = Modifier
                .constrainAs(boxTextFields) {
                    top.linkTo(btnAddPicture.bottom)
                }
                .padding(8.dp)
                .fillMaxSize(),
        ) {
            val (txtNameEvent, txtStartDate, btnAddEndDate, txtVirtualLive, txtWho, txtDetails, btnRepeatEvent, btnPrivate) =
                createRefs()

            OutlinedTextField(
                modifier = Modifier
                    .constrainAs(txtNameEvent) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .border(
                        1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event))
                    ),
                shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event)),
                value = "", onValueChange = {}, placeholder = {
                    Text(text = "Nombre del evento")
                }
            )

            OutlinedTextField(
                modifier = Modifier
                    .constrainAs(txtStartDate) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(txtNameEvent.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .border(
                        1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event))
                    ),
                shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event)),
                value = "", onValueChange = {}, placeholder = {
                    Text(text = "Fecha y hora de inicio")
                })

            IconButton(
                modifier = Modifier.constrainAs(btnAddEndDate) {
                    start.linkTo(txtNameEvent.start)
                    top.linkTo(txtStartDate.bottom)
                },
                onClick = { /*TODO*/ }) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_add_circle),
                        contentDescription = null
                    )
                    Text(
                        text = "Agregar fecha y hora de finalización"
                    )

                }
            }

            OutlinedTextField(
                modifier = Modifier
                    .constrainAs(txtVirtualLive) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(btnAddEndDate.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .border(
                        1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event))
                    ),
                shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event)),
                value = "", onValueChange = {},
                placeholder = {
                    Text(text = "¿Es presencial o virtual?")
                })

            OutlinedTextField(
                modifier = Modifier
                    .constrainAs(txtWho) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(txtVirtualLive.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
                    .border(
                        1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event))
                    ),
                shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event)),
                value = "", onValueChange = {}, placeholder = {
                    Text(text = "¿Quién puede verlo?")
                })

            OutlinedTextField(
                modifier = Modifier
                    .constrainAs(txtDetails) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(txtWho.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 14.dp)
                    .border(
                        1.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event))
                    ),
                shape = RoundedCornerShape(size = dimensionResource(R.dimen.border_text_field_create_event)),
                value = "", onValueChange = {},
                placeholder = {
                    Text(text = "¿Cuáles son los detalles?")
                })

            Row(modifier = Modifier.constrainAs(btnRepeatEvent) {
                start.linkTo(txtNameEvent.start)
                top.linkTo(txtDetails.bottom)
            }) {

                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.align(Alignment.TopStart),
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_repeat),
                            contentDescription = null
                        )
                        Text(text = "Repetir evento")
                    }

                    IconButton(
                        modifier = Modifier.align(Alignment.TopEnd),
                        onClick = {}
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = null,
                        )
                    }
                }
            }

            IconButton(onClick = {
                showCustomDialogWithResult = !showCustomDialogWithResult
            }, modifier = Modifier.constrainAs(btnPrivate) {
                start.linkTo(txtNameEvent.start)
                top.linkTo(btnRepeatEvent.bottom)
            }) {
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_lock_open),
                        contentDescription = null
                    )
                    Text(text = "Public")
                }

            }
        }
    }

    if (showCustomDialogWithResult) {
        PrivateDialog(
            onDismiss = {
                showCustomDialogWithResult = !showCustomDialogWithResult
            },
            onNegativeClick = {
                showCustomDialogWithResult = !showCustomDialogWithResult
            },
            onPositiveClick = {
                showCustomDialogWithResult = !showCustomDialogWithResult
            }
        )
    }
}


@Composable
private fun PrivateDialog(
    onDismiss: () -> Unit,
    onNegativeClick: () -> Unit,
    onPositiveClick: () -> Unit
) {

    Dialog(onDismissRequest = onDismiss) {

        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {

            Column(
                modifier = Modifier.padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Privacidad del evento",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.Gray)
                )

                // Color Selection
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(text = "Elige quién puede ver el evento y unirse a él.")
                        Spacer(
                            modifier = Modifier
                                .height(8.dp)
                                .fillMaxWidth()
                        )

                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.align(Alignment.TopStart),
                            ) {
                                OutlinedButton(
                                    modifier = Modifier.size(50.dp),
                                    shape = CircleShape,
                                    onClick = {}
                                ) {
                                    Icon(
                                        tint = Color.White,
                                        imageVector = Icons.Rounded.Lock,
                                        contentDescription = null,
                                    )
                                }
                                Column(
                                    modifier = Modifier.padding(start = 8.dp)
                                ) {
                                    Text(
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp
                                        ),
                                        text = "Privado"
                                    )
                                    Text(
                                        style = TextStyle(color = Color.Gray),
                                        text = "Solo las personas invitadas"
                                    )
                                }
                            }
                            RadioButton(
                                modifier = Modifier.align(Alignment.TopEnd),
                                selected = false, onClick = { /*TODO*/ })
                        }

                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.align(Alignment.TopStart),
                            ) {
                                OutlinedButton(
                                    modifier = Modifier.size(50.dp),
                                    shape = CircleShape,
                                    onClick = {}
                                ) {
                                    Icon(
                                        tint = Color.White,
                                        painter = painterResource(id = R.drawable.ic_public),
                                        contentDescription = null,
                                    )
                                }
                                Column(
                                    modifier = Modifier.padding(start = 8.dp)
                                ) {
                                    Text(
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp
                                        ),
                                        text = "Public"
                                    )
                                    Text(
                                        style = TextStyle(color = Color.Gray),
                                        text = "Cualquiera puede verlo"
                                    )
                                }
                            }
                            RadioButton(
                                modifier = Modifier.align(Alignment.TopEnd),
                                selected = false, onClick = { /*TODO*/ })
                        }

                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.align(Alignment.TopStart),
                            ) {
                                OutlinedButton(
                                    modifier = Modifier.size(50.dp),
                                    shape = CircleShape,
                                    onClick = {}
                                ) {
                                    Icon(
                                        tint = Color.White,
                                        painter = painterResource(id = R.drawable.ic_people),
                                        contentDescription = null,
                                    )
                                }
                                Column(
                                    modifier = Modifier.padding(start = 8.dp)
                                ) {
                                    Text(
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp
                                        ),
                                        text = "Amigos"
                                    )
                                    Text(
                                        style = TextStyle(color = Color.Gray),
                                        text = "A tus amigo de Events"
                                    )
                                }
                            }
                            RadioButton(
                                modifier = Modifier.align(Alignment.TopEnd),
                                selected = false, onClick = { /*TODO*/ })
                        }

                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Row(
                                modifier = Modifier.align(Alignment.TopStart),
                            ) {
                                OutlinedButton(
                                    modifier = Modifier.size(50.dp),
                                    shape = CircleShape,
                                    onClick = {}
                                ) {
                                    Icon(
                                        tint = Color.White,
                                        painter = painterResource(id = R.drawable.ic_group),
                                        contentDescription = null,
                                    )
                                }
                                Column(
                                    modifier = Modifier.padding(start = 8.dp)
                                ) {
                                    Text(
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp
                                        ),
                                        text = "Grupo"
                                    )
                                    Text(
                                        style = TextStyle(color = Color.Gray),
                                        text = "Miembros de un grupo al que perteneces"
                                    )
                                }
                            }
                            RadioButton(
                                modifier = Modifier.align(Alignment.TopEnd),
                                selected = false, onClick = { /*TODO*/ })
                        }
                    }
                }

                // Buttons
                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    TextButton(onClick = onNegativeClick) {
                        Text(text = "CANCEL")
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    TextButton(onClick = {
                        onPositiveClick()
                    }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CreateEventScreenPreview() {
    EventaiTheme {
        Surface {
            CreateEventScreen()
        }
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DialogPreview() {
    EventaiTheme {
        Surface {
            PrivateDialog({}, {}, {})
        }
    }
}