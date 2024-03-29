package com.example.model.remote.character

import com.example.model.remote.base.PageInfo
import com.example.testutils.BaseModelTest
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class CharacterResponseTest : BaseModelTest() {

    override fun checkModelClass(): Class<*> {
        return CharacterResponse::class.java
    }

    override fun checkModelFields(): List<String> {
        return listOf(
            "info",
            "results"
        )
    }

    @Test
    fun createResponse() {
        val pageInfo: PageInfo = mockk()
        val characterInfo: CharacterInfo = mockk()

        val response = CharacterResponse(
            pageInfo = pageInfo,
            results = listOf(characterInfo)
        )

        Assert.assertEquals(characterInfo, response.results?.first())
        Assert.assertEquals(pageInfo, response.pageInfo)
    }
}