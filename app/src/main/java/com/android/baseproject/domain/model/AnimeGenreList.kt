package com.android.baseproject.domain.model
import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

class AnimeGenreList : ArrayList<AnimeGenreListItem>()

@Serializable
data class AnimeGenreListItem(
    @SerialName("_id")
    var id: String
)