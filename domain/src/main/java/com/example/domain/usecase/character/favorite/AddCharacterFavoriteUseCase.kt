package com.example.domain.usecase.character.favorite

import androidx.annotation.VisibleForTesting
import com.example.repository.character.CharacterRepository
import com.example.framework.usecase.LocalUseCase
import com.example.model.dto.character.CharacterDto
import com.example.model.dto.character.toCharacterEntity
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AddCharacterFavoriteUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : LocalUseCase<AddCharacterFavoriteUseCase.Params, Unit>() {

    data class Params(
        val character: CharacterDto
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        val dto = params.character
        repository.saveFavorite(dto.toCharacterEntity())
        emit(Unit)
    }
}