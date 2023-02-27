package com.example.local.db

import com.example.testutils.TestRobolectric
import com.local.dao.CharacterFavoriteDao
import com.local.dao.EpisodeFavoriteDao
import com.local.db.SampleDatabase
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class SampleDatabaseTest : TestRobolectric() {

    @MockK
    lateinit var database: SampleDatabase

    @MockK
    lateinit var characterFavoriteDao: CharacterFavoriteDao

    @MockK
    lateinit var episodeFavoriteDao: EpisodeFavoriteDao

    @Test
    fun checkCharacterFavoriteDao() {
        every { database.characterFavoriteDao() } returns characterFavoriteDao

        MatcherAssert.assertThat(
            database.characterFavoriteDao(),
            CoreMatchers.instanceOf(CharacterFavoriteDao::class.java)
        )
    }

    @Test
    fun checkEpisodeFavoriteDao() {
        every { database.episodeFavoriteDao() } returns episodeFavoriteDao

        MatcherAssert.assertThat(
            database.episodeFavoriteDao(),
            CoreMatchers.instanceOf(EpisodeFavoriteDao::class.java)
        )
    }
}