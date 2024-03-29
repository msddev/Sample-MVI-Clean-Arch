package com.example.model.remote.character

import com.example.model.remote.base.PageInfo
import com.example.model.remote.character.CharacterInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @Json(name = "info") val pageInfo: PageInfo?,
    @Json(name = "results") val results: List<CharacterInfo>?
)