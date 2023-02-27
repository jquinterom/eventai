package com.eventai.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.eventai.R
import com.eventai.ui.composables.EventCard
import com.eventai.ui.theme.EventaiTheme

@Composable
fun FavoritesEventsScreen() {
    EventaiTheme() {
        LazyColumn(
            modifier = Modifier.padding(
                dimensionResource(id = R.dimen.margin_start_card)
            )
        ) {
            items(3) {
                EventCard()
            }
        }
    }
}