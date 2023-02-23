package com.example.characters.detail

import com.example.domain.usecase.character.GetCharacterDetailUseCase
import com.example.framework.base.mvi.BaseViewState
import com.example.framework.base.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetail: GetCharacterDetailUseCase
) : MviViewModel<BaseViewState<CharacterDetailViewState>, CharacterDetailEvent>() {

    override fun onTriggerEvent(eventType: CharacterDetailEvent) {
        when (eventType) {
            is CharacterDetailEvent.LoadDetail -> onLoadDetail(eventType.id)
        }
    }

    private fun onLoadDetail(id: Int) = safeLaunch {
        val params = GetCharacterDetailUseCase.Params(detailId = id)
        execute(getCharacterDetail(params)) { dto ->
            setState(BaseViewState.Data(CharacterDetailViewState(character = dto)))
        }
    }
}