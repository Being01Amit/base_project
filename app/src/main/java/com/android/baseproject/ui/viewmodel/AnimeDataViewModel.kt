package com.android.baseproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.baseproject.data.utils.AnimeEndPoints
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.usecases.APIErrorCode
import com.android.baseproject.domain.usecases.AllAnimeListUseCases
import com.android.baseproject.domain.usecases.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDataViewModel @Inject constructor(private val userCases: AllAnimeListUseCases) :
    ViewModel() {
    val _allAnimeList = MutableLiveData<AnimeListModel>()
    val allAnimeList: MutableLiveData<AnimeListModel>
        get() = _allAnimeList

    init {
        getAllAnimeList()
    }

    private fun getAllAnimeList() {
        viewModelScope.launch(Dispatchers.Main) {
            when (val response = userCases.execute(AnimeEndPoints.ANIME)) {
                is Result.Error -> {
                    when (response.error) {
                        APIErrorCode.BAD_REQUEST -> TODO()
                        APIErrorCode.UNAUTHORIZED -> TODO()
                        APIErrorCode.FORBIDDEN -> TODO()
                        APIErrorCode.NOT_FOUND -> TODO()
                        APIErrorCode.INVALID_REQUEST -> TODO()
                        APIErrorCode.INTERNAL_SERVER_ERROR -> TODO()
                    }
                }

                is Result.Success -> {

                }
            }

        }
    }
}