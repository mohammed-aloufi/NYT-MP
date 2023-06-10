package com.example.nyt_mp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.nyt_mp.utils.ConnectivityObserver
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConnectivityObserverImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : ConnectivityObserver {

    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private fun getInitialConnectionStatus(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) ?: false
        } else {
            // for APIs bellow 23
            val activeNetwork = connectivityManager.activeNetworkInfo
            activeNetwork != null && activeNetwork.isConnectedOrConnecting
        }
    }

    @RequiresApi(Build.VERSION_CODES.N) // requires api level 24 and above
    override fun observeNetworkState(): Flow<Boolean> = callbackFlow {
        // send the initial connection status
        send(getInitialConnectionStatus())
        // This callbackFlow will send a new value when ever a new callback is triggered
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                // TO send an emit in the callback flow we need to use launch to do it in a coroutine
                launch { send(true) }
            }

            override fun onUnavailable() {
                super.onUnavailable()
                launch { send(false) }
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                launch {
                    delay(1000L)
                    send(getInitialConnectionStatus())
                }
            }
        }

        connectivityManager.registerNetworkCallback(NetworkRequest.Builder().build(), callback)
        // awaitClose will executes the code in it's block when the scope where observeNetworkState()
        // has been cancelled, eg. viewModelScope.
        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
        // distinctUntilChanged will only allow the callbackFlow to send a new value when it is not as the last one.
    }.distinctUntilChanged()
}
