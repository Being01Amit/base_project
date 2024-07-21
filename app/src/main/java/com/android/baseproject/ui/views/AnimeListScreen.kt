package com.android.baseproject.ui.views

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.ui.viewmodel.AnimeDataViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


/*fun AnimeListScreen(

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val lazyGridState = rememberLazyGridState()
        val animeList by viewModel.animeListModel.collectAsState()
        when (animeList) {
            is ResultWrapper.Error -> {
                when((animeList as ResultWrapper.Error).error){
                    DataError.NetworkError.BAD_REQUEST -> TODO()
                    DataError.NetworkError.UNAUTHORIZED -> TODO()
                    DataError.NetworkError.FORBIDDEN -> TODO()
                    DataError.NetworkError.NOT_FOUND -> TODO()
                    DataError.NetworkError.INTERNAL_SERVER_ERROR -> TODO()
                    DataError.NetworkError.UNKNOWN -> TODO()
                    DataError.NetworkError.TIMEOUT -> TODO()
                    DataError.NetworkError.NO_INTERNET_CONNECTION -> TODO()
                    DataError.NetworkError.JSON_PARSING_ERROR -> TODO()
                }
            }

            is ResultWrapper.Loading -> {
                Log.d("TAG----->", "Loading")
            }

            is ResultWrapper.Success -> {
                val animeResponse = (animeList as ResultWrapper.Success).data
                Log.d("TAG----->", Gson().toJson(animeResponse))
            }
        }
//        AnimeListGridView(animeList = animeList.value!!, lazyGridState = lazyGridState)
    }
}*/
/*

@Composable
fun AnimeListGridView(
    animeList: AnimeListModel,
    lazyGridState: LazyGridState
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = lazyGridState,
        contentPadding = PaddingValues(5.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalArrangement = Arrangement.Start,
        userScrollEnabled = true
    ) {
        items(animeList.data.size) {

        }
    }
}*/
