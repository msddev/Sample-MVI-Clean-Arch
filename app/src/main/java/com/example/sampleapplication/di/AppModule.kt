package com.example.sampleapplication.di

import android.content.Context
import com.example.framework.base.app.AppInitializer
import com.example.framework.base.app.AppInitializerImpl
import com.example.framework.base.app.NetworkConfig
import com.example.framework.base.app.TimberInitializer
import com.example.framework.pref.CacheManager
import com.example.sampleapplication.app.SampleApp
import com.example.sampleapplication.app.SampleNetworkConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideApplication(): SampleApp {
        return SampleApp()
    }

    @Provides
    @Singleton
    fun provideNetworkConfig(): NetworkConfig {
        return SampleNetworkConfig()
    }

    @Provides
    @Singleton
    fun provideCacheManager(@ApplicationContext context: Context): CacheManager {
        return CacheManager(context)
    }

    @Provides
    @Singleton
    fun provideTimberInitializer(
        networkConfig: NetworkConfig
    ) = TimberInitializer(networkConfig.isDev())

    @Provides
    @Singleton
    fun provideAppInitializer(
        timberInitializer: TimberInitializer
    ): AppInitializer {
        return AppInitializerImpl(timberInitializer)
    }
}