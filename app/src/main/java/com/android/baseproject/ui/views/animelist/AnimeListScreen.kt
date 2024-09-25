package com.android.baseproject.ui.views.animelist

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.android.baseproject.domain.DataError
import com.android.baseproject.domain.ResultWrapper
import com.android.baseproject.domain.model.AnimeDataModel
import com.android.baseproject.domain.model.AnimeListModel
import com.android.baseproject.ui.sharedElements.ProgressBar

@Composable
fun AnimeListScreen(
    animeListViewModel: AnimeDataViewModel = hiltViewModel<AnimeDataViewModel>()
) {
    var loading by remember {
        mutableStateOf(false)
    }

    var page by remember {
        mutableStateOf(1)
    }

    val listState = rememberLazyListState()
    val lazyColumState = rememberLazyListState()
    animeListViewModel.getAllAnimeList(page)
    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex + listState.layoutInfo.visibleItemsInfo.size }
            .collect { visibleItemsCount ->
                if (visibleItemsCount >= listState.layoutInfo.totalItemsCount && !loading) {
                    // When the user reaches the end, load more items
                    animeListViewModel.getAllAnimeList(page++)
                }
            }
    }

    val animeList by animeListViewModel.animeListModel.collectAsState()

    when (animeList) {
        is ResultWrapper.Error -> {
            when ((animeList as ResultWrapper.Error).error) {
                DataError.NetworkError.BAD_REQUEST -> TODO()
                DataError.NetworkError.UNAUTHORIZED -> TODO()
                DataError.NetworkError.FORBIDDEN -> TODO()
                DataError.NetworkError.NOT_FOUND -> TODO()
                DataError.NetworkError.INTERNAL_SERVER_ERROR -> TODO()
                DataError.NetworkError.UNKNOWN -> TODO()
                DataError.NetworkError.TIMEOUT -> TODO()
                DataError.NetworkError.NO_INTERNET_CONNECTION -> TODO()
                DataError.NetworkError.JSON_PARSING_ERROR -> TODO()
                DataError.LocalError.NULL_POINTER_EXCEPTION -> Log.d(
                    "TAG----->",
                    "NULL POINTER EXCEPTION"
                )
            }
        }

        is ResultWrapper.Loading -> {
            loading = true
            ProgressBar(loading)
        }

        is ResultWrapper.Success -> {
            loading = false
            val animeResponse = (animeList as ResultWrapper.Success).data
            ProgressBar(loading = loading)
            SectionIndexer()
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                AnimeListGridView(animeList = animeResponse, lazyColumState = lazyColumState) {
                    println("item : ${it}]")
                }
            }
        }
    }
}

@Composable
fun SectionIndexer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

    }
}

@Composable
fun AnimeListGridView(
    lazyColumState: LazyListState,
    animeList: AnimeListModel? = null,
    onAnimeClick: (AnimeDataModel) -> Unit
) {
    Box {
        LazyColumn(
            state = lazyColumState,
            contentPadding = PaddingValues(5.dp),
            userScrollEnabled = true,
            modifier = Modifier.padding(5.dp)
        ) {
            items(animeList!!.data.size) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(vertical = 10.dp),
                    elevation = CardDefaults.elevatedCardElevation(16.dp),
                    onClick = {
                        onAnimeClick(animeList.data[item])
                    }
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(.30f)
                        ) {
                            val imageModel = ImageRequest.Builder(LocalContext.current)
                                .data(data = animeList.data[item].image)
                                .crossfade(true)
                                .build()

                            AsyncImage(
                                model = imageModel,
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth(),
                                contentDescription = animeList.data[item].title
                            )
                        }

                        Spacer(modifier = Modifier.height(5.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top,
                            modifier = Modifier
                                .padding(start = 5.dp)
                        ) {
                            AnimeText(
                                label = "Title",
                                text = animeList.data[item].title,
                                modifier = Modifier
                                    .padding(vertical = 10.dp, horizontal = 6.dp),
                                1,
                                fontWeight = FontWeight.Bold
                            )
                            AnimeText(
                                label = "Description",
                                text = animeList.data[item].synopsis,
                                modifier = Modifier
                                    .padding(top = 2.dp, start = 3.dp, end = 3.dp),
                                2,
                                fontWeight = FontWeight.Normal
                            )

                            AnimeText(
                                label = "Ranking",
                                text = animeList.data[item].ranking.toString(),
                                modifier = Modifier
                                    .padding(top = 5.dp, start = 3.dp, end = 3.dp),
                                1,
                                fontWeight = FontWeight.Normal
                            )

                            AnimeText(
                                label = "No of Episodes",
                                text = animeList.data[item].episodes.toString(),
                                modifier = Modifier
                                    .padding(top = 5.dp, start = 3.dp, end = 3.dp),
                                2,
                                fontWeight = FontWeight.Normal
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            CardComp(animeList.data[item].genres)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AnimeText(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    maxLine: Int,
    fontWeight: FontWeight,
) {
    Row {
        Text(
            text = "$label: $text",
            modifier = modifier,
            fontSize = TextUnit.Unspecified,
            maxLines = maxLine,
            fontWeight = fontWeight
        )
    }
}

@Composable
fun CardComp(genres: List<String>) {
    LazyRow {
        items(genres.size) { item ->
            Card(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .padding(5.dp),
                colors = CardDefaults.cardColors(Color.Transparent),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = genres[item],
                    modifier = Modifier
                        .padding(5.dp)
                )
            }
        }
    }
}