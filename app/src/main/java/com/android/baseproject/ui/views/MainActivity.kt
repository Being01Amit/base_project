package com.android.baseproject.ui.views

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.baseproject.ui.viewmodel.AnimeDataViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel = viewModels<AnimeDataViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GetData()
        }
    }

    @Composable
    private fun GetData(viewModel: AnimeDataViewModel = hiltViewModel<AnimeDataViewModel>()) {
            viewModel.allAnimeList.observe(this) { AnimeList ->
                Log.d("TAG---->", AnimeList.toString())
            }
    }
}