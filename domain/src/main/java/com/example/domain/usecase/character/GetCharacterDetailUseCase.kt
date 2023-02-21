package com.example.domain.usecase.character

import androidx.annotation.VisibleForTesting
import com.example.framework.extension.isNull
import com.example.framework.extension.orZero
import com.example.framework.network.DataState
import com.example.framework.network.apiCall
import com.example.framework.usecase.DataStateUseCase
import com.example.model.dto.character.CharacterDto
import com.example.model.dto.character.toCharacterDto
import com.example.model.dto.episode.toEpisodeDto
import com.example.repository.character.CharacterRepository
import com.example.repository.episode.EpisodeRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetCharacterDetailUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val charRepo: CharacterRepository,
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val episodeRepo: EpisodeRepository
) : DataStateUseCase<GetCharacterDetailUseCase.Params, CharacterDto>() {

    data class Params(
        val url: String? = null,
        val detailId: Int? = null
    )

    override suspend fun FlowCollector<DataState<CharacterDto>>.execute(params: Params) {
        val getCharacter = if (params.detailId.isNull()) {
            charRepo.getCharacter(url = params.url.orEmpty()).toCharacterDto()
        } else {
            charRepo.getCharacter(characterId = params.detailId.orZero()).toCharacterDto()
        }
        val service = apiCall { getCharacter }
        service.map { characterDto ->
            val characterFav = charRepo.getFavorite(characterDto.id.orZero())
            characterDto.isFavorite = characterFav != null

            characterDto.episodes.forEach {
                val episodeService = apiCall { episodeRepo.getEpisode(it) }
                if (episodeService is DataState.Success) {
                    characterDto.episodeDtoList.add(episodeService.result.toEpisodeDto())
                }
            }
        }

        emit(service)
    }
}