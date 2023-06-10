package com.example.nyt_mp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import com.example.nyt_mp.utils.Constants.ALL

@Composable
fun SectionsList(
    sections: List<String>,
    onSectionClicked: (String) -> Unit,
) {
    val selectedSection = remember { mutableStateOf(ALL) }
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 10.dp)
    ) {
        items(sections) { section ->
            SectionItem(
                sectionName = section,
                isSelected = selectedSection.value == section
            ) {
                selectedSection.value = section
                onSectionClicked(section)
            }
        }
    }
}