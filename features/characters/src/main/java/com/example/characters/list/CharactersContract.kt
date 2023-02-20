package com.example.characters.list

import androidx.paging.PagingData
import com.example.model.dto.character.CharacterDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class CharactersViewState(
    val pagedData: Flow<PagingData<CharacterDto>> = emptyFlow(),
    val favorList: List<CharacterDto> = emptyList()
)

sealed class CharactersEvent {
    object LoadCharacters : CharactersEvent()
    data class AddOrRemoveFavorite(val characterDto: CharacterDto) : CharactersEvent()
    object LoadFavorites : CharactersEvent()
    data class DeleteFavorite(val id: Int) : CharactersEvent()
}