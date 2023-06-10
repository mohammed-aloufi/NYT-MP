package com.example.nyt_mp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.nyt_mp.R
import com.example.nyt_mp.presentation.ui.theme.GreyText

@Composable
fun AppTopAppBar() {
    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.Black)
            .padding(start = 10.dp, end = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(id = R.drawable.nyt_logo),
            contentDescription = null,
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
        )
    }
}