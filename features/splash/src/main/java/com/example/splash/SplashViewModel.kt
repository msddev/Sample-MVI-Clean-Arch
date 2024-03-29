package com.example.splash

import com.example.domain.usecase.welcome.ReadOnBoardingUseCase
import com.example.framework.base.mvvm.MvvmViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val readOnBoardingUseCase: ReadOnBoardingUseCase
) : MvvmViewModel() {

    private val _startWelcome = MutableStateFlow(false)
    val startWelcome = _startWelcome.asStateFlow()

    init {
        readOnBoardingState()
    }

    private fun readOnBoardingState() = safeLaunch {
        call(readOnBoardingUseCase(Unit)) { completed ->
            _startWelcome.value = !completed
        }
    }
}