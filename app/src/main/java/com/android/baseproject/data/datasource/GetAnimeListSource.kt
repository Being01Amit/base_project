package com.android.baseproject.data.datasource

import com.android.baseproject.data.network.APIService
import com.android.baseproject.domain.model.AnimeListModel
import javax.inject.Inject

class GetAnimeListSource @Inject constructor(private val apiService: APIService) {
    suspend fun getAllAnimeList(): List<AnimeListModel> {
        return apiService.getAllAnime()
    }
}