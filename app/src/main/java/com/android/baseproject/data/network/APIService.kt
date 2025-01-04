package com.android.baseproject.data.network

import android.telecom.Call
import com.android.baseproject.data.utils.AnimeEndPoints.ANIME
import com.android.baseproject.domain.model.AnimeListModel
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {
    @GET("{path}")
    @Headers(
        "x-rapidapi-key: b64221e9ecmshd25bff8a6ceb11fp1e0e42jsne439091752d4",
        "x-rapidapi-host: anime-db.p.rapidapi.com"
    )
    suspend fun getAllAnime(@Path("path") path: String): ResponseBody

    @POST("{path}")
    suspend fun postAPI(@Path("path") path : String, @Body requestBody: RequestBody) : ResponseBody
}