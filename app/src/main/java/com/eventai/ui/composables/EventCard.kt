package com.eventai.ui.composables

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.eventai.R
import com.eventai.ui.theme.EventaiTheme

@Composable
fun EventCard() {
    Card(
        modifier = Modifier
            .shadow(dimensionResource(id = R.dimen.shadow_card))
            .padding(bottom = dimensionResource(id = R.dimen.padding_bottom_content_card)),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.rounded_corner_shape))
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            val (image, textBody, buttons) = createRefs()

            // Image
            SubcomposeAsyncImage(
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                    }
                    .fillMaxWidth()
                    .padding(bottom = dimensionResource(id = R.dimen.margin_bottom_image_header)),
                model = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fphotos5.appleinsider.com%2Fgallery%2F46655-92123-Apple-Event-xl.jpg&f=1&nofb=1&ipt=206b9a10baee26afb818ed526999c5d55ec060c88b491d1749aeb68051b8b288&ipo=images",
                contentDescription = null,
            ) {
                val state = painter.state
                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                    CircularProgressIndicator()
                } else {
                    SubcomposeAsyncImageContent()
                }
            }

            // Text
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_start_content_card),
                        end = dimensionResource(id = R.dimen.padding_start_content_card),
                    )
                    .constrainAs(textBody) {
                        start.linkTo(parent.start)
                        top.linkTo(image.bottom)
                        end.linkTo(parent.end)
                    }) {
                Text(

                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    text = "FRI, 3 DE MAR. AT 22:30 UTC-05"
                )
                Text(
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    text = "Apple Event - Cupertino"
                )
                Text(
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    text = "Online"
                )
                Text(
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    ),
                    text = "57 interested - 23 will attend"
                )
            }

            // Buttons
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = dimensionResource(id = R.dimen.padding_start_content_card),
                        end = dimensionResource(id = R.dimen.padding_start_content_card),
                        bottom = dimensionResource(id = R.dimen.padding_bottom_content_card)
                    )
                    .constrainAs(buttons) {
                        start.linkTo(textBody.start)
                        top.linkTo(textBody.bottom)
                        end.linkTo(textBody.end)
                    }
            ) {
                val (buttonStart, buttonShare) = createRefs()
                Button(
                    modifier = Modifier
                        .constrainAs(buttonStart) {
                            start.linkTo(parent.start)
                        }
                        .fillMaxWidth(.8f)
                        .padding(end = dimensionResource(id = R.dimen.padding_end_button)),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star),
                        contentDescription = null
                    )
                    Text(text = "I like it")
                }

                Button(
                    modifier = Modifier
                        .constrainAs(buttonShare) {
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth(.2f),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Gray),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_share),
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EventCardPreview() {
    EventaiTheme {
        Surface {
            EventCard()
        }
    }
}