package com.eventai.ui.screens

import android.content.res.Configuration
import android.view.Surface
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.eventai.ui.composables.EventCard
import com.eventai.ui.theme.EventaiTheme
import com.eventai.R

@Composable
fun EventsListScreen() {
    EventaiTheme() {
        LazyColumn(
            modifier = Modifier.padding(
                dimensionResource(id = R.dimen.margin_start_card)
            )
        ) {
            items(9) {
                EventCard()
            }
        }
    }
}

@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EventListPreview() {
    EventaiTheme {
        Surface {
            EventsListScreen()
        }
    }
}