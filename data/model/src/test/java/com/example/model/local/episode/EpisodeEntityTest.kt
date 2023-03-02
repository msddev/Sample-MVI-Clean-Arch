package com.example.model.local.episode

import com.example.model.local.episode.EpisodeEntity
import org.junit.Assert
import org.junit.Test

class EpisodeEntityTest {
    @Test
    fun checkCorrectAttributes() {
        val id = 1
        val name = "The Ricklantis Mixup"

        val entity = EpisodeEntity(
            id = id,
            name = name,
            "",
            "",
            "",
            "",
            emptyList()
        )

        Assert.assertEquals(id, entity.id)
        Assert.assertEquals(name, entity.name)
    }
}