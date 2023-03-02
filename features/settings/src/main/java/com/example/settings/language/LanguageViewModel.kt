package com.example.settings.language

import androidx.compose.runtime.mutableStateOf
import com.example.framework.base.mvvm.MvvmViewModel
import com.example.model.dto.language.LanguageDto
import com.example.provider.LanguageProvider
import com.example.provider.ResourceProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LanguageViewModel @Inject constructor(
    private val languageProvider: LanguageProvider,
    private val resourceProvider: ResourceProvider
) : MvvmViewModel() {

    private var languages = emptyList<LanguageDto>()

    val langs = mutableStateOf<List<LanguageDto>>(emptyList())

    init {
        languages = getLanguages()
        getLanguage()
    }

    fun saveLanguageCode(code: String) {
        languageProvider.saveLanguageCode(code)
    }

    private fun getLanguageCode(): String {
        return languageProvider.getLanguageCode()
    }

    private fun getLanguage() {
        languages.map {
            it.isSelected = it.code == getLanguageCode()
        }
        langs.value = languages
    }

    private fun getLanguages(): List<LanguageDto> {
        return listOf(
            LanguageDto(
                id = 1,
                code = "en",
                name = resourceProvider.getString(com.example.theme.R.string.text_language_english),
                isSelected = false
            ),
            LanguageDto(
                id = 2,
                code = "fa",
                name = resourceProvider.getString(com.example.theme.R.string.text_language_persian),
                isSelected = false
            )
        )
    }
}