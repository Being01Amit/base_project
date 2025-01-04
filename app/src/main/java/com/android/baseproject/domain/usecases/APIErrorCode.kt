package com.android.baseproject.domain.usecases

import com.android.baseproject.domain.usecases.Error

enum class APIErrorCode : Error {
    BAD_REQUEST,
    UNAUTHORIZED,
    FORBIDDEN,
    NOT_FOUND,
    INVALID_REQUEST,
    INTERNAL_SERVER_ERROR

}