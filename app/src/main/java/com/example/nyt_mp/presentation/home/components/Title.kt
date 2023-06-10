package com.example.nyt_mp.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nyt_mp.presentation.ui.theme.DarkNeutral1

@Composable
fun Title(
    text: String
) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        color = DarkNeutral1,
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp)
    )
}