package com.android.baseproject.domain.repository

import com.android.baseproject.domain.model.AnimeListModel

interface AnimeListRepository {
    suspend fun getAllAnimeList() : List<AnimeListModel>
}