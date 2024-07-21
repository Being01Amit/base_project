package com.android.baseproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.usecases.AllAnimeListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDataViewModel @Inject constructor(private val userCases: AllAnimeListUseCases) : ViewModel() {
    private val _animeListData =
        MutableStateFlow<ResultWrapper<AnimeListModel, DataError.NetworkError>>(ResultWrapper.Loading())
    val animeListModel: StateFlow<ResultWrapper<AnimeListModel, DataError.NetworkError>> = _animeListData

    init {
        getAllAnimeList()
    }

    fun getAllAnimeList() {
        viewModelScope.launch(Dispatchers.Main) {
           val response = userCases.execute()
            _animeListData.value = response
        }
    }
}