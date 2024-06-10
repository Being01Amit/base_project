package com.android.baseproject.domain.model
import com.google.gson.annotations.SerializedName


data class AnimeListModel(
    @SerializedName("data")
    var `data`: List<Data>,
    @SerializedName("meta")
    var meta: Meta
)

data class Data(
    @SerializedName("alternativeTitles")
    var alternativeTitles: List<String>,
    @SerializedName("episodes")
    var episodes: Int,
    @SerializedName("genres")
    var genres: List<String>,
    @SerializedName("hasEpisode")
    var hasEpisode: Boolean,
    @SerializedName("hasRanking")
    var hasRanking: Boolean,
    @SerializedName("_id")
    var id: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("link")
    var link: String,
    @SerializedName("ranking")
    var ranking: Int,
    @SerializedName("status")
    var status: String,
    @SerializedName("synopsis")
    var synopsis: String,
    @SerializedName("thumb")
    var thumb: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("type")
    var type: String
)

data class Meta(
    @SerializedName("page")
    var page: Int,
    @SerializedName("size")
    var size: Int,
    @SerializedName("totalData")
    var totalData: Int,
    @SerializedName("totalPage")
    var totalPage: Int
)