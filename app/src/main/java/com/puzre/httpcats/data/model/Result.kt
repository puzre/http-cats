package com.puzre.httpcats.data.model

sealed class Result<T: Any> {
    data class Success<T: Any>(val data: T): Result<T>()
    data class Exception<T: Any>(val exception: java.lang.Exception): Result<T>()
    data class Error<T: Any>(val message: String): Result<T>()
}
