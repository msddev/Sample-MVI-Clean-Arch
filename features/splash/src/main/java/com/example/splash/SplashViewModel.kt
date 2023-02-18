package com.example.splash

import com.example.domain.usecase.welcome.ReadOnBoarding
import com.example.framework.base.mvvm.MvvmViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val readOnBoarding: ReadOnBoarding
) : MvvmViewModel() {

    private val _startWelcome = MutableStateFlow(false)
    val startWelcome = _startWelcome.asStateFlow()

    init {
        readOnBoardingState()
    }

    private fun readOnBoardingState() = safeLaunch {
        call(readOnBoarding(Unit)) { completed ->
            _startWelcome.value = !completed
        }
    }
}