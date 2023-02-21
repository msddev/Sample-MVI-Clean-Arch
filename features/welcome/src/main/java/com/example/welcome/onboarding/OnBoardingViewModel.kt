package com.example.welcome.onboarding

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.welcome.ReadOnBoardingUseCase
import com.example.domain.usecase.welcome.SaveOnBoardingUseCase
import com.example.framework.base.mvvm.MvvmViewModel
import com.example.welcome.navgraph.ON_BOARDING_SCREEN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    private val readOnBoardingUseCase: ReadOnBoardingUseCase
) : MvvmViewModel() {

    private val _startDestination: MutableState<String> =
        mutableStateOf(ON_BOARDING_SCREEN)
    val startDestination: State<String> = _startDestination

    fun saveOnBoardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        val params = SaveOnBoardingUseCase.Params(completed)
        call(saveOnBoardingUseCase(params))
    }
}