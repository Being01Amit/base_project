package com.android.baseproject.domain.repository

import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel

interface AnimeListRepository {
    suspend fun getAllAnimeList(queryMap: Map<String, String>) : ResultWrapper<AnimeListModel, DataError.NetworkError>
}