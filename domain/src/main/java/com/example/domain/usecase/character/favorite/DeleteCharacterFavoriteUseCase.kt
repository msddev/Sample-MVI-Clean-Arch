package com.example.domain.usecase.character.favorite

import androidx.annotation.VisibleForTesting
import com.example.repository.character.CharacterRepository
import com.example.framework.usecase.LocalUseCase
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class DeleteCharacterFavoriteUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : LocalUseCase<DeleteCharacterFavoriteUseCase.Params, Unit>() {

    data class Params(
        val characterId: Int
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.deleteFavoriteById(params.characterId)
        emit(Unit)
    }
}