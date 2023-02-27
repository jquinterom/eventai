package com.eventai.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.eventai.R
import com.eventai.ui.theme.EventaiTheme

@Composable
fun CreateEventScreen() {

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
                    .background(color = Color.Black)
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
            val (txtNameEvent, txtStartDate, btnAddEndDate, txtVirtualLive, txtWho, txtDetails, btnRepeatEvent) =
                createRefs()

            TextField(
                modifier = Modifier
                    .constrainAs(txtNameEvent) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = "Nombre del evento", onValueChange = {})

            TextField(
                modifier = Modifier
                    .constrainAs(txtStartDate) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(txtNameEvent.bottom)
                    }
                    .fillMaxWidth().padding(bottom = 8.dp),
                value = "Fecha y hora de inicio", onValueChange = {})

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
                    Text(text = "Agregar fecha y hora de finalización")
                }
            }

            TextField(
                modifier = Modifier
                    .constrainAs(txtVirtualLive) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(btnAddEndDate.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = "¿Es presencial o virtual?", onValueChange = {})

            TextField(
                modifier = Modifier
                    .constrainAs(txtWho) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(txtVirtualLive.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                value = "¿Quién puede verlo?", onValueChange = {})

            TextField(
                modifier = Modifier
                    .constrainAs(txtDetails) {
                        start.linkTo(txtNameEvent.start)
                        end.linkTo(txtNameEvent.end)
                        top.linkTo(txtWho.bottom)
                    }
                    .fillMaxWidth()
                    .padding(bottom = 14.dp),
                value = "¿Cuáles son los detalles?", onValueChange = {})

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

                    Icon(
                        modifier = Modifier.align(Alignment.TopEnd),
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                    )
                }
            }
        }
    }
}


//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview
@Composable
fun CreateEventScreenPreview() {
    EventaiTheme {
        Surface {
            CreateEventScreen()
        }
    }
}