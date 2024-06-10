package com.android.baseproject.data.repository

import com.android.baseproject.data.datasource.GetAnimeListSource
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository
import javax.inject.Inject

class AnimeListRepositoryImp @Inject constructor(private val remoteDataSource: GetAnimeListSource) :
    AnimeListRepository {
    override suspend fun getAllAnimeList(): List<AnimeListModel> {
        return remoteDataSource.getAllAnimeList()
    }
}