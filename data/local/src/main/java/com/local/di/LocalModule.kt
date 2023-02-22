package com.local.di

import android.content.Context
import androidx.room.Room
import com.example.local.BuildConfig
import com.local.dao.CharacterFavoriteDao
import com.local.dao.EpisodeFavoriteDao
import com.local.db.SampleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

private const val DB_NAME = "db_name"

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {
    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return BuildConfig.DB_NAME
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbname: String,
        @ApplicationContext context: Context
    ): SampleDatabase {
        return Room.databaseBuilder(context, SampleDatabase::class.java, dbname)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterFavoriteDao(appDatabase: SampleDatabase): CharacterFavoriteDao {
        return appDatabase.characterFavoriteDao()
    }

    @Provides
    @Singleton
    fun provideEpisodeFavoriteDao(appDatabase: SampleDatabase): EpisodeFavoriteDao {
        return appDatabase.episodeFavoriteDao()
    }
}