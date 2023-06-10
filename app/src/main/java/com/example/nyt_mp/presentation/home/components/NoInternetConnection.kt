package com.example.nyt_mp.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nyt_mp.R
import com.example.nyt_mp.presentation.ui.theme.GreyText

@Composable
fun NoInternetConnection() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_internet),
            contentDescription = stringResource(R.string.lbl_no_internet_message),
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = stringResource(R.string.lbl_no_internet),
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 24.sp,
            modifier = Modifier.padding(10.dp)
        )
        Text(
            text = stringResource(R.string.lbl_no_internet_message),
            fontWeight = FontWeight.Bold,
            color = GreyText,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
    }
}
