package com.android.baseproject.data.network

import com.android.baseproject.data.utils.AnimeEndPoints.ANIME
import com.android.baseproject.data.utils.AnimeEndPoints.GENRE
import com.android.baseproject.domain.model.AnimeGenreList
import com.android.baseproject.domain.model.AnimeListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface APIService {
    @GET(ANIME)
    suspend fun getAllAnime(
        @QueryMap query: Map<String, String>
    ): Response<AnimeListModel>

    @GET(GENRE)
    suspend fun animeGenre(): Response<AnimeGenreList>
}