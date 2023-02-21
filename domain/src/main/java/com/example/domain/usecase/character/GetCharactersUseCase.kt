package com.example.domain.usecase.character

import androidx.annotation.VisibleForTesting
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.repository.character.CharacterRepository
import com.example.framework.usecase.FlowPagingUseCase
import com.example.model.dto.character.CharacterDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: CharacterRepository
) : FlowPagingUseCase<GetCharactersUseCase.Params, CharacterDto>() {

    data class Params(
        val pagingConfig: PagingConfig,
        val options: Map<String, String>
    )

    override fun execute(params: Params): Flow<PagingData<CharacterDto>> {
        return Pager(
            config = params.pagingConfig,
            pagingSourceFactory = { CharacterPagingSource(repository, params.options) }
        ).flow
    }
}