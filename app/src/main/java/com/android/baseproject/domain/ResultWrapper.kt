package com.android.baseproject.domain

typealias RootError = Error

sealed interface ResultWrapper<out Data, out Error : RootError> {
    data class Success<out Data, out Error : RootError>(val data: Data) : ResultWrapper<Data, Error>
    data class Error<out Data, out Error : RootError>(val error: Error) : ResultWrapper<Data, Error>
    class Loading<Data, Error : RootError> : ResultWrapper<Data, Error>
}