package com.example.domain.di

import android.annotation.SuppressLint
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@SuppressLint("VisibleForTests")
@Module(
    includes = [
        WelcomeModule::class
    ]
)
@InstallIn(SingletonComponent::class)
class DomainModule