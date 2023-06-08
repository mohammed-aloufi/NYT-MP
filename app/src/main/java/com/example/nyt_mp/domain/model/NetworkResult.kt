package com.example.nyt_mp.domain.model

sealed class NetworkResult<out R> {
    data class Success <out T> (val data : T) : NetworkResult<T>()
    data class Failure(val error : String) : NetworkResult<Nothing>()
    object Loading : NetworkResult<Nothing>()
}
