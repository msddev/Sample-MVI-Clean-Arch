package com.example.domain.usecase.welcome

import com.example.repository.welcome.WelcomeRepository
import com.example.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SaveOnBoardingTest : MockkUnitTest() {
    @RelaxedMockK
    lateinit var repository: WelcomeRepository

    @SpyK
    @InjectMockKs
    private lateinit var saveOnBoarding: SaveOnBoardingUseCase

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)
        val params = SaveOnBoardingUseCase.Params(true)

        // Act (When)
        saveOnBoarding.invoke(params)

        // Assert (Then)
        coVerify { saveOnBoarding.invoke(any()) }
    }

    @Test
    fun collectExecute() = runTest {
        // Arrange (Given)
        val params = SaveOnBoardingUseCase.Params(true)

        // Act (When)
        saveOnBoarding.invoke(params).single()

        // Assert (Then)
        coVerify { repository.saveOnBoardingState(params.completed) }
    }
}