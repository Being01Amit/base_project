package com.android.baseproject.domain.repository

import okhttp3.RequestBody
import okhttp3.ResponseBody

interface AnimeListRepository {
    suspend fun getAllAnimeList(endPoint: String, response: (ResponseBody) -> Unit)

    suspend fun postAPI(
        endPoint: String,
        requestBody: RequestBody,
        response: (ResponseBody) -> Unit
    )
}