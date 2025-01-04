package com.android.baseproject.domain.usecases

import com.android.baseproject.domain.repository.AnimeListRepository
import javax.inject.Inject

class AllAnimeListUseCases @Inject constructor(private val repository: AnimeListRepository){
    suspend fun execute(endPoint: String) : Result<Unit, Error> {
        return try {
            val response = repository.getAllAnimeList(endPoint)
            Result.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(handleException(e))
        }
    }

    private fun handleException(exception: Exception): APIErrorCode {
        // Here you can map different exceptions to your APIErrorCode
        return when (exception) {
            is java.net.SocketTimeoutException -> APIErrorCode.INTERNAL_SERVER_ERROR
            is java.io.IOException -> APIErrorCode.BAD_REQUEST
            else -> APIErrorCode.INTERNAL_SERVER_ERROR
        }
    }
}