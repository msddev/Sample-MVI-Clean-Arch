package com.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.framework.room.dao.BaseDao
import com.example.model.local.episode.EpisodeEntity

@Dao
interface EpisodeFavoriteDao : BaseDao<EpisodeEntity> {
    @Query("SELECT * FROM ${EpisodeEntity.TABLE_NAME}")
    suspend fun getFavoriteList(): List<EpisodeEntity>

    @Query("SELECT * FROM ${EpisodeEntity.TABLE_NAME} WHERE id = :favoriteId")
    suspend fun getFavorite(favoriteId: Int): EpisodeEntity?

    @Query("DELETE FROM ${EpisodeEntity.TABLE_NAME}")
    suspend fun deleteFavoriteList()

    @Query("DELETE FROM ${EpisodeEntity.TABLE_NAME} WHERE id = :favoriteId")
    suspend fun deleteFavoriteById(favoriteId: Int)
}