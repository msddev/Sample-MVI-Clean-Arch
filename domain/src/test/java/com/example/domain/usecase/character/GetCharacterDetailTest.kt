package com.example.domain.usecase.character

import com.example.repository.character.CharacterRepository
import com.example.repository.episode.EpisodeRepository
import com.example.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetCharacterDetailTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var charRepo: CharacterRepository

    @MockK(relaxed = true)
    lateinit var episodeRepo: EpisodeRepository

    @SpyK
    @InjectMockKs
    private lateinit var characterDetail: GetCharacterDetailUseCase

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val detailId = -1

        // Act (When)
        val params = GetCharacterDetailUseCase.Params(detailId = detailId)
        characterDetail.invoke(params)

        // Assert (Then)
        coVerify { characterDetail.invoke(any()) }
    }

    @Test
    fun collectExecute() = runTest {
        // Arrange (Given)
        val detailId = 1

        // Act (When)
        val param = GetCharacterDetailUseCase.Params(detailId = detailId)
        characterDetail.invoke(param).single()

        // Assert (Then)
        coVerify { charRepo.getCharacter(characterId = detailId) }
    }
}