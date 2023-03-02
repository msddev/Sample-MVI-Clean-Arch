package com.example.repository.di

import com.example.remote.service.CharacterService
import com.example.testutils.MockkUnitTest
import com.local.dao.CharacterFavoriteDao
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class RepositoryModuleTest : MockkUnitTest() {

    private lateinit var repositoryModule: RepositoryModule

    override fun onCreate() {
        super.onCreate()
        repositoryModule = RepositoryModule()
    }

    @Test
    fun verifyProvideCharacterRepository() {
        val service = mockk<CharacterService>()
        val dao = mockk<CharacterFavoriteDao>()
        val repository = repositoryModule.provideCharacterRepository(service, dao)

        Assert.assertEquals(service, repository.service)
        Assert.assertEquals(dao, repository.dao)
    }
}