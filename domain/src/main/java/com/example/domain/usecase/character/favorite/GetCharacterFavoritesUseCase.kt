package com.example.domain.usecase.character.favorite

import androidx.annotation.VisibleForTesting
import com.example.framework.usecase.LocalUseCase
import com.example.model.dto.character.CharacterDto
import com.example.model.dto.character.toFavoriteDtoList
import com.example.repository.character.CharacterRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetCharacterFavoritesUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : LocalUseCase<Unit, List<CharacterDto>>() {

    override suspend fun FlowCollector<List<CharacterDto>>.execute(params: Unit) {
        val favors = repository.getFavoriteList()
        emit(favors.toFavoriteDtoList())
    }
}