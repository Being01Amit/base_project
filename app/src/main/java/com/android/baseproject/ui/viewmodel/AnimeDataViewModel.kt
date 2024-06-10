package com.android.baseproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.domain.repository.AnimeListRepository
import com.android.baseproject.domain.usecases.AllAnimeListUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDataViewModel @Inject constructor(private val userCases: AllAnimeListUseCases) : ViewModel() {
    val _allAnimeList = MutableLiveData<AnimeListModel>()
    val allAnimeList: MutableLiveData<AnimeListModel>
        get() = _allAnimeList

    init {
        getAllAnimeList()
    }

    private fun getAllAnimeList() {
        viewModelScope.launch(Dispatchers.Main) {
            _allAnimeList.value = userCases.execute()
        }
    }
}