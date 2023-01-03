package eu.kanade.tachiyomi.animeextension.all.kamyroll

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccessToken(
    val access_token: String,
    val token_type: String,
)

@Serializable
data class LinkData(
    val id: String,
    val media_type: String
)

@Serializable
data class Images(
    val thumbnail: ArrayList<Image>?,
    val poster_tall: ArrayList<Image>?,
    val poster_wide: ArrayList<Image>?
) {
    @Serializable
    data class Image(
        val width: Int,
        val height: Int,
        val type: String,
        val source: String
    )
}

@Serializable
data class Metadata(
    val is_dubbed: Boolean,
    val is_mature: Boolean,
    val is_subbed: Boolean,
    val maturity_ratings: String,
    val episode_count: Int?,
    val is_simulcast: Boolean?,
    val season_count: Int?
)

@Serializable
data class Updated(
    val total: Int,
    val items: ArrayList<Item>
) {
    @Serializable
    data class Item(
        val id: String,
        val series_id: String,
        val series_title: String,
        val description: String,
        val images: Images
    )
}

@Serializable
data class SearchResult(
    val total: Int,
    val items: ArrayList<SearchItem>
) {
    @Serializable
    data class SearchItem(
        val type: String,
        val total: Int,
        val items: ArrayList<Item>
    ) {
        @Serializable
        data class Item(
            val id: String,
            val description: String,
            val media_type: String,
            val title: String,
            val images: Images,
            val series_metadata: Metadata?,
            val movie_listing_metadata: Metadata?
        )
    }
}

@Serializable
data class EpisodeList(
    val total: Int,
    val items: ArrayList<Item>
) {
    @Serializable
    data class Item(
        @SerialName("__class__")
        val media_class: String,
        val id: String,
        val type: String?,
        val is_subbed: Boolean?,
        val is_dubbed: Boolean?,
        val episodes: ArrayList<Episode>?
    ) {
        @Serializable
        data class Episode(
            val id: String,
            val title: String,
            val season_number: Int,
            val sequence_number: Int,
            val is_subbed: Boolean,
            val is_dubbed: Boolean,
            @SerialName("episode_air_date")
            val air_date: String
        )
    }
}

@Serializable
data class MediaResult(
    val id: String,
    val title: String,
    val description: String,
    val images: Images,
    val maturity_ratings: String,
    val content_provider: String,
    val is_mature: Boolean,
    val is_subbed: Boolean,
    val is_dubbed: Boolean,
    val episode_count: Int?,
    val season_count: Int?,
    val media_count: Int?,
    val is_simulcast: Boolean?
)

@Serializable
data class RawEpisode(
    val id: String,
    val title: String,
    val season: Int,
    val episode: Int,
    val air_date: String
)

@Serializable
data class EpisodeData(
    val ids: List<String>
)

@Serializable
data class VideoStreams(
    val streams: List<Stream>,
    val subtitles: List<Subtitle>
) {
    @Serializable
    data class Stream(
        @SerialName("audio_locale")
        val audio: String,
        @SerialName("hardsub_locale")
        val hardsub: String,
        val url: String
    )

    @Serializable
    data class Subtitle(
        val locale: String,
        val url: String
    )
}

fun <T> List<T>.thirdLast(): T {
    if (size < 3) throw NoSuchElementException("List has less than three elements")
    return this[size - 3]
}
