package com.example.domain.usecase.welcome

import androidx.annotation.VisibleForTesting
import com.example.framework.usecase.LocalUseCase
import com.example.repository.welcome.WelcomeRepository
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class SaveOnBoarding @Inject constructor(
    @get:VisibleForTesting(otherwise = VisibleForTesting.PROTECTED)
    internal val repository: WelcomeRepository
) : LocalUseCase<SaveOnBoarding.Params, Unit>() {

    data class Params(
        val completed: Boolean
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        repository.saveOnBoardingState(params.completed)
        emit(Unit)
    }
}