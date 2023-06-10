package com.example.nyt_mp.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nyt_mp.R

@Composable
fun AppTopAppBar(
    showBackIcon: Boolean = false,
    onBackClicked: () -> Unit = {}
) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Black)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        if (showBackIcon) {
            Box(Modifier.padding(horizontal = 15.dp).fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_24),
                    contentDescription = "Back",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.align(Alignment.CenterStart).clickable { onBackClicked() }
                )
            }
        } else {
            Image(
                painter = painterResource(id = R.drawable.nyt_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .weight(1f)
            )
        }
    }
}