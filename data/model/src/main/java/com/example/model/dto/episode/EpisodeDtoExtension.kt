package com.example.model.dto.episode

import com.example.framework.extension.orZero
import com.example.model.local.episode.EpisodeEntity
import com.example.model.remote.episode.EpisodeInfo

fun EpisodeInfo.toEpisodeDto() = EpisodeDto(
    id = id.orZero(),
    name = name.orEmpty(),
    url = url,
    airDate = airDate,
    created = created,
    episode = episode,
    characters = characters.orEmpty()
)

fun List<EpisodeInfo>.toEpisodeDtoList() = map { it.toEpisodeDto() }

fun EpisodeEntity.toEpisodeDto() = EpisodeDto(
    id = id.orZero(),
    name = name,
    url = url,
    airDate = airDate,
    created = created,
    episode = episode,
    characters = characters
)

fun List<EpisodeEntity>.toFavoriteDtoList() = map { it.toEpisodeDto() }

fun EpisodeDto.toEpisodeEntity() = EpisodeEntity(
    id = id.orZero(),
    name = name,
    url = url.orEmpty(),
    airDate = airDate.orEmpty(),
    created = created.orEmpty(),
    episode = episode.orEmpty(),
    characters = characters
)