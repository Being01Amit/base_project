package com.android.baseproject.data.repository

import coil.network.HttpException
import com.android.baseproject.data.network.APIService
import com.android.baseproject.data.utils.ApiNetworkErrorCode
import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository
import com.google.gson.JsonParseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException

class AnimeListRepositoryImp(private val apiService: APIService) : AnimeListRepository {
    override suspend fun getAllAnimeList(queryMap: Map<String, String>): ResultWrapper<AnimeListModel, DataError> {
        return try {
            withContext(Dispatchers.IO) {
                val response = apiService.getAllAnime(queryMap)
                ResultWrapper.Success(response.body()!!)
            }
        } catch (e: HttpException) {
            when (e.response.code) {
                ApiNetworkErrorCode.BadRequest.code -> ResultWrapper.Error(DataError.NetworkError.BAD_REQUEST)
                ApiNetworkErrorCode.Unauthorized.code -> ResultWrapper.Error(DataError.NetworkError.UNAUTHORIZED)
                ApiNetworkErrorCode.Forbidden.code -> ResultWrapper.Error(DataError.NetworkError.FORBIDDEN)
                ApiNetworkErrorCode.NotFound.code -> ResultWrapper.Error(DataError.NetworkError.NOT_FOUND)
                ApiNetworkErrorCode.InternalServerError.code -> ResultWrapper.Error(DataError.NetworkError.INTERNAL_SERVER_ERROR)
                else -> ResultWrapper.Error(DataError.NetworkError.UNKNOWN)
            }
        } catch (e: SocketTimeoutException) {
            when (e.cause) {
                is ConnectException -> ResultWrapper.Error(DataError.NetworkError.TIMEOUT)
                else -> ResultWrapper.Error(DataError.NetworkError.UNKNOWN)
            }
        } catch (e: JsonParseException) {
            ResultWrapper.Error(DataError.NetworkError.JSON_PARSING_ERROR)
        } catch (e: IOException) {
            ResultWrapper.Error(DataError.NetworkError.NO_INTERNET_CONNECTION)
        } catch (e: NullPointerException) {
            ResultWrapper.Error(DataError.LocalError.NULL_POINTER_EXCEPTION)
        }
    }
}