package com.puzre.httpcats.mvi

sealed class Lse<T: Any>{
    class Loading<T: Any>: Lse<T>()
    data class Success<T: Any>(val intent: T): Lse<T>()
    data class Error<T: Any>(val intent: T): Lse<T>()
}
