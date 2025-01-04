package com.android.baseproject.domain.repository

import okhttp3.RequestBody
import okhttp3.ResponseBody

interface AnimeListRepository {

    suspend fun postAPI(
        endPoint: String,
        requestBody: RequestBody,
        response: (ResponseBody) -> Unit
    )

}