package com.example.splash

import com.example.framework.base.mvvm.MvvmViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SplashViewModel @Inject constructor(

) : MvvmViewModel() {

    private val _startWelcome = MutableStateFlow(false)
    val startWelcome = _startWelcome.asStateFlow()

    init {
        readOnBoardingState()
    }

    private fun readOnBoardingState() = safeLaunch {
        /*call(readOnBoarding(Unit)) { completed ->
            _startWelcome.value = !completed
        }*/
        _startWelcome.value = true
    }
}