package com.example.domain.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(
    includes = [
        WelcomeModule::class
    ]
)
@InstallIn(SingletonComponent::class)
class DomainModule