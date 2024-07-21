package com.android.baseproject.data.datasource

import coil.network.HttpException
import com.android.baseproject.data.network.APIService
import com.android.baseproject.data.utils.ApiNetworkErrorCode
import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel
import com.google.gson.JsonParseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import javax.inject.Inject

/*
class GetAnimeListSource @Inject constructor(private val apiService: APIService) {
    suspend fun getAllAnimeList(queryMap: Map<String, String>): ResultWrapper<AnimeListModel, DataError.NetworkError> {
        
    }
}*/
