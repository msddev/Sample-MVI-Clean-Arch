package com.example.domain.usecase.character.favorite

import com.example.domain.mockdata.MockData
import com.example.framework.extension.orZero
import com.example.model.dto.character.CharacterDto
import com.example.model.dto.character.toCharacterEntity
import com.example.model.local.character.CharacterEntity
import com.example.repository.character.CharacterRepository
import com.example.testutils.MockkUnitTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Test

class UpdateCharacterFavoriteTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var repository: CharacterRepository

    @SpyK
    @MockK
    lateinit var entity: CharacterEntity

    @SpyK
    @InjectMockKs
    private lateinit var updateFavorite: UpdateCharacterFavoriteUseCase

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val dto = mockk<CharacterDto>()

        // Act (When)
        val params = UpdateCharacterFavoriteUseCase.Params(dto)
        updateFavorite.invoke(params)

        // Assert (Then)
        coVerify { updateFavorite.invoke(any()) }
    }

    @Test
    fun collectExecuteSave() = runTest {
        // Arrange (Given)
        val dto = MockData.getCharacterDto()
        val params = UpdateCharacterFavoriteUseCase.Params(dto)

        coEvery { repository.getFavorite(dto.id.orZero()) } returns null

        // Act (When)
        updateFavorite.invoke(params).single()

        // Assert (Then)
        coVerify { repository.saveFavorite(dto.toCharacterEntity()) }
    }

    @Test
    fun collectExecuteDelete() = runTest {
        // Arrange (Given)
        val dto = MockData.getCharacterDto()
        val params = UpdateCharacterFavoriteUseCase.Params(dto)

        coEvery { repository.getFavorite(dto.id.orZero()) } returns entity

        // Act (When)
        updateFavorite.invoke(params).single()

        // Assert (Then)
        coVerify { repository.deleteFavoriteById(dto.id.orZero()) }
    }
}