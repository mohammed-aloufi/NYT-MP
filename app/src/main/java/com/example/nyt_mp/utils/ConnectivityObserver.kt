package com.example.nyt_mp.utils

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    fun observeNetworkState(): Flow<Boolean>
}
