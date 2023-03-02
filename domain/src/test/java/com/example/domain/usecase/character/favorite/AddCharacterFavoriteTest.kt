package com.example.domain.usecase.character.favorite

import com.example.domain.mockdata.MockData
import com.example.model.dto.character.CharacterDto
import com.example.model.dto.character.toCharacterEntity
import com.example.repository.character.CharacterRepository
import com.example.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Test

class AddCharacterFavoriteTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var repository: CharacterRepository

    @SpyK
    @InjectMockKs
    private lateinit var addFavorite: AddCharacterFavoriteUseCase

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val dto = mockk<CharacterDto>()

        // Act (When)
        val params = AddCharacterFavoriteUseCase.Params(dto)
        addFavorite.invoke(params)

        // Assert (Then)
        coVerify { addFavorite.invoke(any()) }
    }

    @Test
    fun collectExecute() = runTest {
        // Arrange (Given)
        val dto = MockData.getCharacterDto()
        val params = AddCharacterFavoriteUseCase.Params(dto)

        // Act (When)
        addFavorite.invoke(params).single()

        // Assert (Then)
        coVerify {
            repository.saveFavorite(dto.toCharacterEntity())
        }
    }
}