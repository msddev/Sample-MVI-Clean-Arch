package com.example.remote.service

import com.example.model.remote.episode.EpisodeInfo
import com.example.model.remote.episode.EpisodeResponse
import retrofit2.http.*

interface EpisodeService {
    @GET(EPISODE)
    suspend fun getEpisodeList(
        @Query("page") page: Int,
        @QueryMap options: Map<String, String>? = null
    ): EpisodeResponse

    @GET("$EPISODE/{id}")
    suspend fun getEpisode(
        @Path("id") episodeId: Int
    ): EpisodeInfo

    @GET
    suspend fun getEpisode(
        @Url url: String
    ): EpisodeInfo

    companion object {
        const val EPISODE = "episode"
    }
}