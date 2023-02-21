package com.example.domain.di

import android.annotation.SuppressLint
import com.example.domain.usecase.welcome.ReadOnBoardingUseCase
import com.example.domain.usecase.welcome.SaveOnBoardingUseCase
import com.example.repository.welcome.WelcomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@SuppressLint("VisibleForTests")
@Module
@InstallIn(SingletonComponent::class)
class WelcomeModule {

    @Singleton
    @Provides
    fun provideSaveOnBoarding(repository: WelcomeRepository): SaveOnBoardingUseCase {
        return SaveOnBoardingUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideReadOnBoarding(repository: WelcomeRepository): ReadOnBoardingUseCase {
        return ReadOnBoardingUseCase(repository)
    }
}