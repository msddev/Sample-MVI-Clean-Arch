package com.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.model.local.character.CharacterEntity
import com.example.model.local.episode.EpisodeEntity
import com.local.converter.StringListConverter
import com.local.dao.CharacterFavoriteDao
import com.local.dao.EpisodeFavoriteDao

@Database(
    entities = [CharacterEntity::class, EpisodeEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringListConverter::class)
abstract class SampleDatabase : RoomDatabase() {
    abstract fun characterFavoriteDao(): CharacterFavoriteDao
    abstract fun episodeFavoriteDao(): EpisodeFavoriteDao
}