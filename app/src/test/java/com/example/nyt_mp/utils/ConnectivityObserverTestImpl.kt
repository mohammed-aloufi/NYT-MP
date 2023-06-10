package com.example.nyt_mp.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ConnectivityObserverTestImpl(): ConnectivityObserver {

    var isOnline = false

    override fun observeNetworkState(): Flow<Boolean> = flow {
        emit(isOnline)
    }
}