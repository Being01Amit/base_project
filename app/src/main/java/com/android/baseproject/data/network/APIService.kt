package com.android.baseproject.data.network

import com.android.baseproject.data.utils.AnimeEndPoints.ANIME
import com.android.baseproject.domain.model.AnimeListModel
import retrofit2.http.GET
import retrofit2.http.Headers

interface APIService {
    @GET(ANIME)
    @Headers(
        "x-rapidapi-key: b64221e9ecmshd25bff8a6ceb11fp1e0e42jsne439091752d4",
        "x-rapidapi-host: anime-db.p.rapidapi.com"
    )
    suspend fun getAllAnime(): AnimeListModel
}