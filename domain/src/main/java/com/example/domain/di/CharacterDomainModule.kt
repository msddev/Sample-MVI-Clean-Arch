package com.example.domain.di

import android.annotation.SuppressLint
import com.example.domain.usecase.character.GetCharacterDetailUseCase
import com.example.domain.usecase.character.GetCharactersUseCase
import com.example.domain.usecase.character.favorite.AddCharacterFavoriteUseCase
import com.example.domain.usecase.character.favorite.DeleteCharacterFavoriteUseCase
import com.example.domain.usecase.character.favorite.GetCharacterFavoritesUseCase
import com.example.domain.usecase.character.favorite.UpdateCharacterFavoriteUseCase
import com.example.repository.character.CharacterRepository
import com.example.repository.episode.EpisodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class CharacterDomainModule {

    @Singleton
    @Provides
    fun provideGetCharacters(repository: CharacterRepository): GetCharactersUseCase {
        return GetCharactersUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetCharacterDetail(
        repository: CharacterRepository,
        episodeRepository: EpisodeRepository
    ): GetCharacterDetailUseCase {
        return GetCharacterDetailUseCase(repository, episodeRepository)
    }

    @Singleton
    @Provides
    fun provideAddCharacterFavorite(repository: CharacterRepository): AddCharacterFavoriteUseCase {
        return AddCharacterFavoriteUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideDeleteCharacterFavorite(repository: CharacterRepository): DeleteCharacterFavoriteUseCase {
        return DeleteCharacterFavoriteUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetCharacterFavorites(repository: CharacterRepository): GetCharacterFavoritesUseCase {
        return GetCharacterFavoritesUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideUpdateCharacterFavorite(repository: CharacterRepository): UpdateCharacterFavoriteUseCase {
        return UpdateCharacterFavoriteUseCase(repository)
    }
}