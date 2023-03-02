package com.example.domain.usecase.character.favorite

import com.example.repository.character.CharacterRepository
import com.example.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetCharacterFavoritesTest : MockkUnitTest() {

    @MockK(relaxed = true)
    lateinit var repository: CharacterRepository

    @SpyK
    @InjectMockKs
    private lateinit var getFavorites: GetCharacterFavoritesUseCase

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)

        // Act (When)
        getFavorites.invoke(Unit)

        // Assert (Then)
        coVerify { getFavorites.invoke(Unit) }
    }

    @Test
    fun collectExecute() = runTest {
        // Arrange (Given)

        // Act (When)
        getFavorites.invoke(Unit).single()

        // Assert (Then)
        coVerify { repository.getFavoriteList() }
    }
}