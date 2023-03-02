package com.example.domain.di

import com.example.repository.welcome.WelcomeRepository
import com.example.testutils.MockkUnitTest
import io.mockk.impl.annotations.MockK
import org.junit.Assert
import org.junit.Test

class WelcomeModuleTest : MockkUnitTest() {
    private lateinit var module: WelcomeModule

    @MockK
    private lateinit var repository: WelcomeRepository

    override fun onCreate() {
        super.onCreate()
        module = WelcomeModule()
    }

    @Test
    fun verifyProvideSaveOnBoarding() {
        val saveOnBoarding = module.provideSaveOnBoarding(repository)

        Assert.assertEquals(repository, saveOnBoarding.repository)
    }

    @Test
    fun verifyProvideReadOnBoarding() {
        val readOnBoarding = module.provideReadOnBoarding(repository)

        Assert.assertEquals(repository, readOnBoarding.repository)
    }
}