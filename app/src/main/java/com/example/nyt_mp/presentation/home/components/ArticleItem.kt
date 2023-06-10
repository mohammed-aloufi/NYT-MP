package com.example.nyt_mp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.nyt_mp.domain.model.Article
import com.example.nyt_mp.presentation.ui.theme.DarkNeutral1
import com.example.nyt_mp.presentation.ui.theme.DarkNeutral3

@Composable
fun ArticleItem(
    article: Article,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
//            .clickable { onClick() }
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = article.media.mediumImgUrl,
            contentDescription = "",
            modifier = Modifier
                .size(130.dp)
                .clip(RoundedCornerShape(size = 16.dp)),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxWidth().height(130.dp).padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = article.section,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = DarkNeutral3,
                maxLines = 1
            )
            Text(
                text = article.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = DarkNeutral1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = article.byLine,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = DarkNeutral3,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}