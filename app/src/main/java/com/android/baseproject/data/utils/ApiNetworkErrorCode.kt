package com.android.baseproject.data.utils

enum class ApiNetworkErrorCode(val code: Int) {
    BadRequest(400),
    Unauthorized(401),
    Forbidden(403),
    NotFound(404),
    InternalServerError(500),
    Unknown(501)
}