package com.example.local.di

import android.content.Context
import com.example.local.BuildConfig
import com.example.testutils.MockkUnitTest
import com.local.dao.CharacterFavoriteDao
import com.local.dao.EpisodeFavoriteDao
import com.local.db.SampleDatabase
import com.local.di.LocalModule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class LocalModuleTest : MockkUnitTest() {

    private lateinit var localModule: LocalModule

    override fun onCreate() {
        super.onCreate()
        localModule = LocalModule()
    }

    @Test
    fun verifyProvideDatabaseName() {
        val databaseName = localModule.provideDatabaseName()
        assertEquals(databaseName, BuildConfig.DB_NAME)
    }

    @Test
    fun verifyProvideDatabase() {
        val context: Context = mockk()
        val databaseName = localModule.provideDatabaseName()
        val database = localModule.provideDatabase(databaseName, context)

        Assert.assertNotNull(database.characterFavoriteDao())
        Assert.assertNotNull(database.episodeFavoriteDao())
    }

    @Test
    fun verifyProvideCharacterFavoriteDao() {
        val database: SampleDatabase = mockk()
        val dao: CharacterFavoriteDao = mockk()

        every { database.characterFavoriteDao() } returns dao

        assertEquals(
            dao,
            localModule.provideCharacterFavoriteDao(database)
        )
        verify { database.characterFavoriteDao() }
    }

    @Test
    fun verifyProvideEpisodeFavoriteDao() {
        val database: SampleDatabase = mockk()
        val dao: EpisodeFavoriteDao = mockk()

        every { database.episodeFavoriteDao() } returns dao

        assertEquals(
            dao,
            localModule.provideEpisodeFavoriteDao(database)
        )
        verify { database.episodeFavoriteDao() }
    }
}