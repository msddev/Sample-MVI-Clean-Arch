package com.example.sampleapplication.di

import android.content.Context
import com.example.framework.pref.CacheManager
import com.example.provider.LanguageProvider
import com.example.provider.ResourceProvider
import com.example.provider.ThemeProvider
import com.example.sampleapplication.provider.AppLanguageProvider
import com.example.sampleapplication.provider.AppResourceProvider
import com.example.sampleapplication.provider.AppThemeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ProviderModule {

    @Provides
    @Singleton
    fun provideThemeProvider(@ApplicationContext context: Context): ThemeProvider {
        return AppThemeProvider(context)
    }

    @Provides
    @Singleton
    fun provideAppResourceProvider(@ApplicationContext context: Context): ResourceProvider {
        return AppResourceProvider(context)
    }

    @Provides
    @Singleton
    fun provideAppLanguageProvider(cacheManager: CacheManager): LanguageProvider {
        return AppLanguageProvider(cacheManager)
    }
}