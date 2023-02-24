package com.example.welcome.view

import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.welcome.ReadOnBoardingUseCase
import com.example.domain.usecase.welcome.SaveOnBoardingUseCase
import com.example.framework.base.mvvm.MvvmViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    private val readOnBoardingUseCase: ReadOnBoardingUseCase
) : MvvmViewModel() {

    fun saveOnBoardingState(completed: Boolean) = viewModelScope.launch(Dispatchers.IO) {
        val params = SaveOnBoardingUseCase.Params(completed)
        call(saveOnBoardingUseCase(params))
    }
}