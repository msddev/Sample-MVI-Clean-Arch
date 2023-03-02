package com.example.domain.usecase.welcome

import com.example.repository.welcome.WelcomeRepository
import com.example.testutils.MockkUnitTest
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import kotlinx.coroutines.test.runTest
import org.junit.Test

class ReadOnBoardingTest : MockkUnitTest() {
    @RelaxedMockK
    lateinit var repository: WelcomeRepository

    @SpyK
    @InjectMockKs
    private lateinit var readOnBoarding: ReadOnBoardingUseCase

    @Test
    fun verifyExecute() = runTest {
        // Arrange (Given)

        // Act (When)
        readOnBoarding.invoke(Unit)

        // Assert (Then)
        coVerify { repository.readOnBoardingState() }
    }
}