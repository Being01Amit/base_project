package com.android.baseproject.domain.usecases

import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository
import javax.inject.Inject

class AllAnimeListUseCases @Inject constructor(private val repository: AnimeListRepository) {
    suspend fun execute() : List<AnimeListModel> {
        return repository.getAllAnimeList()
    }
}