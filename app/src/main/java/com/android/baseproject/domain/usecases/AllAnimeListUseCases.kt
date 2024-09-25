package com.android.baseproject.domain.usecases

import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository

class AllAnimeListUseCases(
    private val repository: AnimeListRepository
) {
    suspend fun animeList(page: Int): ResultWrapper<AnimeListModel, DataError> {
        val queryParams = mapOf(
            "page" to page.toString(),
            "size" to "10",
            "sortBy" to "ranking",
            "sortOrder" to "asc"
        )
        return repository.getAllAnimeList(queryParams)
    }
}