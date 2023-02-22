package com.example.characters.list

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.domain.usecase.character.GetCharactersUseCase
import com.example.domain.usecase.character.favorite.DeleteCharacterFavoriteUseCase
import com.example.domain.usecase.character.favorite.GetCharacterFavoritesUseCase
import com.example.domain.usecase.character.favorite.UpdateCharacterFavoriteUseCase
import com.example.framework.base.mvi.BaseViewState
import com.example.framework.base.mvi.MviViewModel
import com.example.model.dto.character.CharacterDto
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val updateCharacterFavoriteUseCase: UpdateCharacterFavoriteUseCase,
    private val getFavoritesUseCase: GetCharacterFavoritesUseCase,
    private val deleteFavoriteUseCase: DeleteCharacterFavoriteUseCase
) : MviViewModel<BaseViewState<CharactersViewState>, CharactersEvent>() {

    private val config = PagingConfig(pageSize = 20)

    override fun onTriggerEvent(eventType: CharactersEvent) {
        when (eventType) {
            is CharactersEvent.LoadCharacters -> onLoadCharacters()
            is CharactersEvent.AddOrRemoveFavorite -> onAddOrRemoveFavorite(eventType.characterDto)
            is CharactersEvent.DeleteFavorite -> onDeleteFavorite(eventType.id)
            is CharactersEvent.LoadFavorites -> onLoadFavorites()
        }
    }

    private fun onLoadCharacters() = safeLaunch {
        setState(BaseViewState.Loading)
        val params = GetCharactersUseCase.Params(config, hashMapOf())
        val pagedFlow = getCharactersUseCase(params).cachedIn(scope = viewModelScope)
        setState(BaseViewState.Data(CharactersViewState(pagedData = pagedFlow)))
    }

    private fun onAddOrRemoveFavorite(dto: CharacterDto) = safeLaunch {
        val params = UpdateCharacterFavoriteUseCase.Params(dto)
        call(updateCharacterFavoriteUseCase(params))
    }

    private fun onLoadFavorites() = safeLaunch {
        call(getFavoritesUseCase(Unit)) {
            if (it.isEmpty()) {
                setState(BaseViewState.Empty)
            } else {
                setState(BaseViewState.Data(CharactersViewState(favorList = it)))
            }
        }
    }

    private fun onDeleteFavorite(id: Int) = safeLaunch {
        call(deleteFavoriteUseCase(DeleteCharacterFavoriteUseCase.Params(id))) {
            onTriggerEvent(CharactersEvent.LoadFavorites)
        }
    }
}