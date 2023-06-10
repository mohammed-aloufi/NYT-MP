package com.example.nyt_mp.presentation.home.state

data class SectionsState(
    val isLoading: Boolean = false,
    val sections: List<String> = emptyList(),
    val error: String? = null
)
