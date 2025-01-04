package com.android.baseproject.data.repository

import com.android.baseproject.data.datasource.GetAnimeListSource
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject

class AnimeListRepositoryImp @Inject constructor(private val remoteDataSource: GetAnimeListSource) :
    AnimeListRepository {
    override suspend fun getAllAnimeList(endPoint: String, response: (ResponseBody) -> Unit) {
         remoteDataSource.getAllAnimeList(endPoint){
             response(it)
         }
    }

    override suspend fun postAPI(
        endPoint: String,
        requestBody: RequestBody,
        response: (ResponseBody) -> Unit
    ) {
        remoteDataSource
    }
}