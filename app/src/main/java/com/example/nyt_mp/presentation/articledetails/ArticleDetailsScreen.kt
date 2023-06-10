package com.example.nyt_mp.presentation.articledetails

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.presentation.common.AppTopAppBar
import com.example.nyt_mp.presentation.ui.theme.DarkNeutral1
import com.example.nyt_mp.presentation.ui.theme.DarkNeutral3
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ArticleDetailsScreen(
    navigator: DestinationsNavigator,
    article: Article
) {

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.Start) {
        AppTopAppBar(showBackIcon = true) {
            navigator.navigateUp()
        }

        AsyncImage(
            model = article.media.largeImgUrl,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
            Text(
                text = article.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = DarkNeutral1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = article.byLine,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = DarkNeutral3,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = article.publishedDate,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                color = DarkNeutral3,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = article.abstract,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = DarkNeutral1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}