package com.example.characters.list

import androidx.paging.PagingConfig
import com.example.framework.base.mvi.BaseViewState
import com.example.framework.base.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor() :
    MviViewModel<BaseViewState<CharactersViewState>, CharactersEvent>() {

    private val config = PagingConfig(pageSize = 20)

    override fun onTriggerEvent(eventType: CharactersEvent) {
        when (eventType) {
            is CharactersEvent.LoadCharacters -> {
                //onLoadCharacters()
            }
            is CharactersEvent.AddOrRemoveFavorite -> {
                //onAddOrRemoveFavorite(eventType.characterDto)
            }
            is CharactersEvent.DeleteFavorite -> {
                //onDeleteFavorite(eventType.id)
            }
            is CharactersEvent.LoadFavorites -> {
                //onLoadFavorites()
            }
        }
    }

    /*private fun onLoadCharacters() = safeLaunch {
        setState(BaseViewState.Loading)
        val params = GetCharacters.Params(config, hashMapOf())
        val pagedFlow = getCharacters(params).cachedIn(scope = viewModelScope)
        setState(BaseViewState.Data(CharactersViewState(pagedData = pagedFlow)))
    }

    private fun onAddOrRemoveFavorite(dto: CharacterDto) = safeLaunch {
        val params = UpdateCharacterFavorite.Params(dto)
        call(updateCharacterFavorite(params))
    }

    private fun onLoadFavorites() = safeLaunch {
        call(getFavorites(Unit)) {
            if (it.isEmpty()) {
                setState(BaseViewState.Empty)
            } else {
                setState(BaseViewState.Data(CharactersViewState(favorList = it)))
            }
        }
    }

    private fun onDeleteFavorite(id: Int) = safeLaunch {
        call(deleteFavorite(DeleteCharacterFavorite.Params(id))) {
            onTriggerEvent(CharactersEvent.LoadFavorites)
        }
    }*/
}