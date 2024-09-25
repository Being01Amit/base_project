package com.android.baseproject.ui.views.animelist

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
        MutableStateFlow<ResultWrapper<AnimeListModel, DataError>>(ResultWrapper.Loading())
    val animeListModel: StateFlow<ResultWrapper<AnimeListModel, DataError>> = _animeListData

     fun getAllAnimeList(page : Int) {
        viewModelScope.launch(Dispatchers.Main) {
           val response = userCases.animeList(page)
            _animeListData.value = response
        }
    }
}