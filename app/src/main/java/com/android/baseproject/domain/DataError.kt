package com.android.baseproject.domain

sealed interface DataError : Error {
    enum class NetworkError : DataError {
        BAD_REQUEST,
        UNAUTHORIZED,
        FORBIDDEN,
        NOT_FOUND,
        INTERNAL_SERVER_ERROR,
        UNKNOWN,
        TIMEOUT,
        NO_INTERNET_CONNECTION,
        JSON_PARSING_ERROR
    }

    enum class LocalError : DataError

}