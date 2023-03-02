package com.example.characters.detail

import com.example.characters.mockdata.MockData
import org.junit.Assert
import org.junit.Test

class CharacterDetailContractTest {

    private lateinit var event: CharacterDetailEvent

    private lateinit var state: CharacterDetailViewState

    @Test
    fun verifyEventLoadDetail() {
        val characterId = 1
        event = CharacterDetailEvent.LoadDetail(characterId)

        val eventLoadDetail = event as CharacterDetailEvent.LoadDetail
        Assert.assertEquals(characterId, eventLoadDetail.id)
    }

    @Test
    fun verifyStateCharacterDetail() {
        val dto = MockData.getCharacterDto()
        state = CharacterDetailViewState(dto)

        Assert.assertEquals(dto, state.character)
    }
}