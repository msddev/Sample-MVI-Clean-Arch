package com.example.repository.di

import android.annotation.SuppressLint
import android.content.Context
import com.example.remote.service.CharacterService
import com.example.repository.character.CharacterRepository
import com.example.repository.welcome.WelcomeRepository
import com.local.dao.CharacterFavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideWelcomeRepository(
        @ApplicationContext context: Context
    ) = WelcomeRepository(context)

    @Singleton
    @Provides
    fun provideCharacterRepository(
        service: CharacterService,
        dao: CharacterFavoriteDao
    ) = CharacterRepository(service, dao)
}