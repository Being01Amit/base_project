package com.android.baseproject.domain.usecases

import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository

class AllAnimeListUseCases(private val repository: AnimeListRepository) {
    suspend fun execute(): ResultWrapper<AnimeListModel, DataError.NetworkError> {
        val queryParams = mapOf(
            "page" to "1",
            "size" to "10",
            "search" to "Fullmetal",
            "genres" to "Fantasy,Drama",
            "sortBy" to "ranking",
            "sortOrder" to "asc"
        )
        return repository.getAllAnimeList(queryParams)
    }
}