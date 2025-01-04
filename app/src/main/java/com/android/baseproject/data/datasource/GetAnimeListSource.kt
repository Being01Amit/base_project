package com.android.baseproject.data.datasource

import com.android.baseproject.data.network.APIService
import com.android.baseproject.domain.model.AnimeListModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject

class GetAnimeListSource @Inject constructor(private val apiService: APIService) {
    suspend fun getAllAnimeList(endPoint: String, response: (ResponseBody) -> Unit) {
         response(apiService.getAllAnime(endPoint))
    }

    suspend fun getPostRequest(
        endPoint: String,
        requestBody: RequestBody,
        response: (ResponseBody) -> Unit
    ) {
        try {
            response(apiService.postAPI(endPoint, requestBody))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}